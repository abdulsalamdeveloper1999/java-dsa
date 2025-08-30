
class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(validAnagram(s, t));
    }

    public static boolean validAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i : count) {
            if (i > 0) {
                return false;
            }
        }
        return true;

    }

}

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:
// Input: s = "rat", t = "car"
// Output: false
// Constraints:
// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.

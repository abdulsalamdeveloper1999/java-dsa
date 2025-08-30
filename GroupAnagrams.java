
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] anagramsList = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagram(anagramsList));;

    }

    static public List<List<String>> groupAnagram(String[] anagramsList) {

        HashMap<String, List<String>> myMap = new HashMap<>();

        for (int i = 0; i < anagramsList.length; i++) {

            int[] count = new int[26];

            for (char c : anagramsList[0].toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sr = new StringBuilder();

            for (int c : count) {
                sr.append(c).append("#");

            }

            System.out.println(sr.toString());

            if (!myMap.containsKey(sr.toString())) {
                myMap.put(sr.toString(), new ArrayList<>());
            }

            // myMap.get(sr.toString()).add(anagramsList[i]);
            myMap.get(sr.toString()).add(anagramsList[i]);
        }

        return new ArrayList<>(myMap.values());

    }

}

// Given an array of strings strs, group the anagrams together. You can return
// the answer in any order.
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Explanation:
// There is no string in strs that can be rearranged to form "bat".
// The strings "nat" and "tan" are anagrams as they can be rearranged to form
// each other.
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to
// form each other.
// Example 2:
// Input: strs = [""]
// Output: [[""]]
// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]
// Constraints:
// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lowercase English letters.

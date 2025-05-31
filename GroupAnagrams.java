import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));
        // ArrayList<ArrayList<String>> result = groupAnagrams(myList);
        List<List<String>> result2 = optimizedSolution(myList);
        System.out.println(result2);

    }

    public static ArrayList<ArrayList<String>> groupAnagrams(ArrayList<String> anagramList) {

        HashMap<String, ArrayList<String>> myMap = new HashMap<>();

        for (String word : anagramList) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            if (!myMap.containsKey(sortedWord)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                myMap.put(sortedWord, list);

            } else {
                myMap.get(sortedWord).add(word);
                System.out.println(myMap);
            }

        }

        return new ArrayList<>(myMap.values());

    }

    public static List<List<String>> optimizedSolution(ArrayList<String> anagramsList) {

        HashMap<String, ArrayList<String>> myHashMap = new HashMap<>();

        for (String word : anagramsList) {
            int[] count = new int[26];

            // ['a','t','e']

            for (char c : word.toCharArray()) {
                count[c - 'a']++;

                // 'a'-'a' asci value of a is 97 so 97-97=0 now
                // modify the index 0 to 1 becuase we did ++
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            System.out.println(sb);
            String key = sb.toString();
            if (!myHashMap.containsKey(key)) {
                myHashMap.put(key, new ArrayList<>());
            }
            myHashMap.get(key).add(word);
        }

        return new ArrayList<>(myHashMap.values());
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

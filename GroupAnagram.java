import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    public static void main(String[] args) {

        String[] anagramList = { "eat", "tea", "tan", "ate", "nat", "bat" };

        System.out.println(anagrams(anagramList));
        ;

    }

    static public List<List<String>> anagrams(String[] wordsList) {

        HashMap<String, List<String>> myMap = new HashMap<>();
        int[] count = new int[26];
        for (int i = 0; i < wordsList.length; i++) {

            // System.out.println(wordsList.get(i));
            for (char c : wordsList[i].toCharArray()) {

                count[c - 'a']++;
            }

            StringBuilder sr = new StringBuilder();

            for (int c : count) {
                sr.append(c).append("#");
            }

            String myKey = sr.toString();

            if (!myMap.containsKey(myKey)) {
                myMap.put(myKey, new ArrayList<>());
            }

            myMap.get(myKey).add(wordsList[i]);

        }
        return new ArrayList<List<String>>(myMap.values());

    }

}

// Given an array of strings strs, group the anagrams together. You can return
// the answer in any order.
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
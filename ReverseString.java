
public class ReverseString {
    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };

        int leftPointer = 0;
        int rightPointer = s.length - 1;

        while (leftPointer < rightPointer) {
            char temp = s[leftPointer];
            s[leftPointer] = s[rightPointer];
            s[rightPointer] = temp;

            leftPointer++;
            rightPointer--;
        }

        for (char c : s) {
            System.out.println(c);
        }

    }

}

// 344. Reverse String
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Write a function that reverses a string. The input string is given as an
// array of characters s.

// You must do this by modifying the input array in-place with O(1) extra
// memory.

// Example 1:

// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
// Example 2:

// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]
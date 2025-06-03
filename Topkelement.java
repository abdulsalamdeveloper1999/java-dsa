import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topkelement {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 1, 2, 2, 3));
        int k = 2;

        System.out.println(Arrays.toString(topk(nums, k)));
    }

    public static int[] topk(List<Integer> nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        // count freq
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // nums size 6 but .size return from 0 to end so 0-5
        // but we have 6 numbers in numsList so we need 6 buckers
        List<Integer>[] buckets = new List[nums.size() + 1];

        for (int key : freqMap.keySet()) {
            int frq = freqMap.get(key);

            // check if bucket index if there is no list then create
            if (buckets[frq] == null) {
                // this create list in specific index so we can add value to that bucket
                buckets[frq] = new ArrayList<>();
            }

            // this line add suppose frq=3 the at 3 index list it will key which can be
            // integer
            buckets[frq].add(key);
        }

        // now lets find top k element and add to list
        int[] result = new int[k];
        int index = 0;

        // so we start with last number of bucket from buckets
        // now bucket.length 6 becuase it start from index 0 to 6
        // which is 7 then
        // but we have 6 bucket so if we subteact 1 we will have exact 6 iteration
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                }
            }
        }

        return result;

    }

}

// 347. Top K Frequent Elements
// Solved
// Medium
// Given an integer array nums and an integer k, return the k most frequent
// elements. You may return the answer in any order.

// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        //Two sum
        int[] twoSumNums = {2, 7, 11, 15};
        int target = 9;

        // int[] result = twoSumOptimize(twoSumNums, target);
        // System.out.println(Arrays.toString(result));
        int[] res = twoPointerTwoSum(twoSumNums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSumOptimize(int[] nums, int target) {
        //create hashset to store values
        //create a num to check diff and add to hashset
        //if current number and prevous numver in hasst are equal to target add to set ad retur the indices
        //[2,7,11,15]
        HashMap<Integer, Integer> myHashMap = new HashMap<>();
        int diff = 0;

        for (int i = 0; i < nums.length; i++) {

            diff = target - nums[i];
            System.out.println(diff);

            if (myHashMap.containsKey(diff)) {
                System.out.println(myHashMap.get(diff));
                System.out.println(nums[i]);
                int[] result = new int[]{myHashMap.get(diff), i};
                return result;
            }
            myHashMap.put(nums[i], i);

            //{2:0.7:}
            System.out.println(myHashMap);

        }
        return new int[]{};

    }

    public static int[] twoPointerTwoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;

        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }

        }
        return new int[]{};

    }

}

// Given an array of integers nums and an integer target, 
// return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]
// Constraints:
// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.

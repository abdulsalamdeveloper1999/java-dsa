
import java.util.Arrays;
import java.util.HashMap;

class TwoSumTwo {

    public static void main(String[] args) {
        int[] nums = {-1, 0};
        int target = -1;
        int[] twoSum = twoSum(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> myMap = new HashMap();
        int secondNumber = 0;
        for (int i = 0; i < numbers.length; i++) {
            secondNumber = target - numbers[i];
            if (myMap.containsKey(secondNumber)) {
                return new int[]{myMap.get(secondNumber), i};
            }
            myMap.put(numbers[i], i);
        }
        return new int[]{};

    }
}

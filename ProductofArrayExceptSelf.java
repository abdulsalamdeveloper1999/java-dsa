import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        // int[] productExceptSelf = productExceptSelf(nums);
        int[] productExceptSelfOptimal = productExceptSelfOptimal(nums);
        // System.out.println(Arrays.toString(productExceptSelf));
        System.out.println(productExceptSelfOptimal);
    }

    public static int[] productExceptSelf(int[] nums) {

        List<Integer> myArray = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    product = product * nums[j];
                }
            }
            myArray.add(product);
        }
        return myArray.stream().mapToInt(i -> i).toArray();
    }


    //o(n)
    public static int[] productExceptSelfTwo(int[] nums){

        int n=nums.length;
        int[] res=new int[n];
        res[0]=1;


        for (int i = 1; i < n; i++) {

            res[i] = res[i-1]*nums[i-1] ;

            
        }



        return new int[]{};
    }

    //o(1)
    public static int[] productExceptSelfOptimal(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];

        }
        System.out.println(Arrays.toString(res));
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }

        System.out.println(Arrays.toString(res));

        return new int[] {};

    }
}

// Input: nums = [1,2,3,4]

// [1,1,2,]

// Output: [24,12,8,6]
package DSA.Prefix_Sufix;

//To find the product of an array except itself, you can multiply all the elements of the array together and then divide by each element to get the corresponding result.
// However, this method might not handle zero values well (division by zero).
// A better method avoiding division is by using prefix products and suffix products
public class ProductArray { //TC and SC = O(N)

    public static int[] productExceptItself(int[] nums) {
        int length = nums.length;

        // The output array will be used to store the left products initially
        int[] output = new int[length];

        //array of left products -> [1, 1, 2, 6]
        output[0] = 1;
        for (int i = 1; i < length; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }

        // Now, let's take care of the right products -> [24, 12, 8, 6]
        int right_prod = 1;
        for (int i = length - 1; i >= 0; i--) {
            output[i] = output[i] * right_prod; //construct right product and multiply with left products
            right_prod *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = ProductArray.productExceptItself(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

/*
public static int[] productWithDivision(int[] nums) {  //using Division
    int totalProduct = 1;
    int zeroCount = 0;
    for (int num : nums) {  //count zeros and other num product
        if (num == 0) {
            zeroCount++;
            continue;
        }
        totalProduct *= num;
    }

    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        if (zeroCount > 1) {
            result[i] = 0;  // more than one zero → all outputs are zero
        } else if (zeroCount == 1) {
            result[i] = nums[i] == 0 ? totalProduct : 0;
        } else {
            result[i] = totalProduct / nums[i];
        }
    }
    return result;
}

Input:  [1, 2, 3, 4]   → Output: [24, 12, 8, 6]
Input:  [1, 2, 0, 4]   → Output: [0, 0, 8, 0]
Input:  [0, 0, 3]      → Output: [0, 0, 0]
 */
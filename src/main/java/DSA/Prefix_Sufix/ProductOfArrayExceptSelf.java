package DSA.Prefix_Sufix;

import java.util.Arrays;

//https://leetcode.com/problems/product-of-array-except-self/description/
// Without using division - if we want with division, have product of all elements and then divide by itself to have a product without self.
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);

        //1. prefix products
        int left = 1; //left stores the product of all elements to the left of the current element
        for (int i = 0; i < nums.length; i++) {
            output[i] = output[i] * left;  //if you don't want to initialize output array with 1's then use output[i] = left; remaining is same
            left *= nums[i];  //update left to hold latest product
        }

        //2. suffix products
        int right = 1; //right stores the product of all elements to the right of the current element
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * right;
            right *= nums[i]; //update right to hold latest product
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));

        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));  //1 zero - only one value in result

        System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 2, 0, 4})));  //more than 1 zero - all zeros in result
    }
}

/*
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
 */

/*
//Brute Force
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int product = 1;

        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){  //O(n^2)
                if(i==j){
                    continue;
                }
                product *= nums[j];
            }
            arr[i] = product;
            product = 1;
        }
        return arr;
    }
}
*/
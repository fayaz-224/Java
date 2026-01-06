package Array.Advance;

public class MaximumSubarrayProduct {

    static int maxProductBrute(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                maxProd = Math.max(maxProd, prod);
            }
        }
        return maxProd;
    }

    static int maxProduct(int[] nums) {
        int n = nums.length;

        int currMax = nums[0];   // max product ending at current index
        int currMin = nums[0];   // min product ending at current index
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int x = nums[i];

            // If negative, swap currMax and currMin
            if (x < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(x, currMax * x);
            currMin = Math.min(x, currMin * x);

            ans = Math.max(ans, currMax);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,-3,0,-4,-5};
        System.out.println(maxProduct(arr));  //20
    }
}

/*
Input: Nums = [1,2,3,4,5,0]
Output: 120
Explanation:
In the given array, 1×2×3×4×5 gives maximum product value.

Input: Nums = [1,2,-3,0,-4,-5]
Output: 20
Explanation:
In the given array, (-4)×(-5) gives maximum product value.
 */
package DSA.DP;

import java.util.Arrays;

//Longest Increasing Subsequence - Dynamic programming
public class LIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return 0;
        }

        int[] dp = new int[n];  //Memoization - It is a technique to speed up programs by caching the results of expensive function calls
        Arrays.fill(dp, 1);
        int maxLIS = 1;

        for (int i = 1; i < n; i++) {  // Start main pointer
            for (int j = 0; j < i; j++) { // Start second pointer
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Update LIS value at index i
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;  // return maxLIS + 1;  if dp[] is not filled
    }

    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS in nums: " + lis.lengthOfLIS(nums)); // Output: 4

        int[] arr = {3,4,-1,0,6,3};
        System.out.println("Length of LIS in arr: " + lis.lengthOfLIS(arr));
    }
}
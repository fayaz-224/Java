package DSA.DP;

import java.util.Arrays;

//Longest Increasing Subsequence (not necessarily contiguous) - Dynamic programming
public class LIS {

    public int lengthOfLIS(int[] nums) {  //Bottom-Up DP
        int n = nums.length;
        if (nums == null || n == 0) return 0;

        int[] dp = new int[n];  //Memoization - It is a technique to speed up programs by caching the results of expensive function calls
        Arrays.fill(dp, 1);
        int maxLIS = 1;

        for (int i = 1; i < n; i++) {  // current element
            for (int j = 0; j < i; j++) { // previous elements
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Update LIS value at index i
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;  // return maxLIS + 1;  if dp[] is not filled
    }

    int lengthOfLIS2(int arr[], int n, int idx, int prev_index, int[][] dp) { //Top-Down DP
        if (idx == n) return 0;

        if (dp[idx][prev_index + 1] != -1) {  //[prev_index+1 becoz -> dp[idx][-1] ← ❌ ArrayIndexOutOfBoundsException (arrays can't have negative indices)
            return dp[idx][prev_index + 1];
        }

        int take = 0;
        if (prev_index == -1 || arr[idx] > arr[prev_index]) {
            take = 1 + lengthOfLIS2(arr, n, idx + 1, idx, dp);  //imp: prev_index = idx
        }

        int noTake = lengthOfLIS2(arr, n, idx + 1, prev_index, dp);

        dp[idx][prev_index + 1] = Math.max(take, noTake);

        return dp[idx][prev_index + 1];
    }

    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS in nums: " + lis.lengthOfLIS(nums)); // 4

        int[] arr = {3,4,-1,0,6,3};
        int n = arr.length;
        int dp[][] = new int[n][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("Length of LIS in arr: " + lis.lengthOfLIS2(arr, n, 0, -1, dp)); // 3
    }
}
package DSA.DP;

import java.util.Arrays;

//Given an array arr & sum, the task is to count all subsets of the given array with a sum equal to a given sum.
public class SubsetSumCount {

    //Diff from SubsetSum; In SubsetSum we do || with dp[][] inside loop
    //                 but in CountSubsetSum we do + operation with dp[][]
    static int countSubsets1(int[] arr, int sum) {  //Memoization
        int n = arr.length;
        int[][] memo = new int[n + 1][sum + 1];  //for int[] dp we use + or - in below recursion with in if-else
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return countSubsetsMemo(arr, n, sum, memo);
    }
    public static int countSubsetsMemo(int[] arr, int n, int sum, int[][] dp) {
        if (sum == 0) return 1;
        if (n == 0) return 0;

        if (dp[n][sum] != -1) return dp[n][sum];

        if (arr[n - 1] <= sum)
            dp[n][sum] = countSubsetsMemo(arr, n - 1, sum - arr[n - 1], dp)
                    + countSubsetsMemo(arr, n - 1, sum, dp);
        else
            dp[n][sum] = countSubsetsMemo(arr, n - 1, sum, dp);

        return dp[n][sum];
    }

    public static int countSubsets2(int[] arr, int sum) { //Tabulation
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        // Base case: If the sum is 0 for i elements, then there's one subset (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int target = 1; target <= sum; target++) {
                if (arr[i - 1] <= target) {
                    dp[i][target] = dp[i-1][target - arr[i-1]]
                                        + dp[i-1][target];  //take
                } else {
                    dp[i][target] = dp[i - 1][target];  //no take
                }
                //dp[i][target] %= mod;  //if larger values are given - to avoid overflow
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println("Number of subsets with sum " + sum + ": " + countSubsets1(arr, sum));
    }
}


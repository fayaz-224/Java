package Array;

//Given an array arr of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.
public class SubsetSum {

    public static int countSubsetsWithSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];  //1st idx = arr, 2nd idx = sum

        // Base case: If the sum is 0 for i elements, then there's one subset (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // If the current element can be included, add the count of subsets without the element
                    // and the count of subsets including the element from the previous row
                    dp[i][j] = dp[i-1][j]  //not take
                            + dp[i-1][j - arr[i-1]];  //take
                } else {
                    // If the current element is greater than the sum, exclude it
                    dp[i][j] = dp[i - 1][j];
                }
                //dp[i][j] %= mod;  //if larger values are given - to avoid overflow
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println("Number of subsets with sum " + sum + ": " + countSubsetsWithSum(arr, sum));
    }
}

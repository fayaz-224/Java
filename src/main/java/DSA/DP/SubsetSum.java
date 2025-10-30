package DSA.DP;

//Given an array arr & sum, the task is to find that the subset is possible with given sum.
public class SubsetSum {

    public static boolean subsetsWithSum1(int[] arr, int sum) {  //Memoization
        int n = arr.length;
        Boolean[][] dp = new Boolean[n+1][sum+1]; //for boolean dp we use || in below recursion with only if.
        return helper(arr, n, sum, dp);
    }
    private static boolean helper(int[] arr, int n, int target, Boolean[][] dp) {
        // Base cases
        if (target == 0) return true; // if target=0 then we can have an empty subset
        if (n == 0) return false; // if no elements then we cant make any subset for given sum

        if (dp[n][target] != null)
            return dp[n][target];

        boolean take = false;
        if (arr[n-1] <= target)
            take = helper(arr, n - 1, target - arr[n-1], dp);

        boolean notTake = helper(arr, n - 1, target, dp);

        // Store result
        dp[n][target] = take || notTake;

        return dp[n][target]; //we can directly return with above line
    }

    public static boolean subsetsWithSum2(int[] arr, int sum) {  //Tabulation
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];  //1-based indexing dp table, if we use o-based dp then we must manually setup First element

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int target = 1; target <= sum; target++) {
                if (arr[i - 1] <= target) {
                    dp[i][target] = dp[i-1][target - arr[i-1]]
                                        || dp[i - 1][target];  //include or exclude
                } else {
                    dp[i][target] = dp[i - 1][target]; //exclude as it's greater than target
                }
                //dp[i][target] %= mod;  //if larger values are given - to avoid overflow
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println("Subset is found? " + subsetsWithSum1(arr, sum));
    }
}
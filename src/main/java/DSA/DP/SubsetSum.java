package DSA.DP;

//Given an array arr of non-negative integers and an integer sum, the task is to find that the subset is possible with given sum.
public class SubsetSum {

    public static boolean subsetsWithSum(int[] arr, int sum) {  //DP
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];  //1-based indexing dp table, if we use o-based dp then we must manually setup First element

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // Fill the subset table in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int target = 1; target <= sum; target++) {
                if (arr[i - 1] <= target) {
                    // If the current element can be included
                    dp[i][target] = dp[i - 1][target] || dp[i - 1][target - arr[i-1]];
                } else {
                    // If the current element is greater than the sum, exclude it -> if(target < arr[i-1])
                    dp[i][target] = dp[i - 1][target];
                }
                //dp[i][target] %= mod;  //if larger values are given - to avoid overflow
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println("Subset is found? " + subsetsWithSum(arr, sum));
    }
}

/*
public class SubsetSumRecursive {

    public static boolean isSubsetSum(int[] set, int n, int sum) {  //Using Recursion
        // Base cases
        if (sum == 0) return true;
        if (n == 0 && sum != 0) return false;

        // If last element is greater than sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

        // Else check if the sum can be obtained by any of the following:
        // 1. Including the last element
        // 2. Excluding the last element
        return isSubsetSum(set, n - 1, sum)
            || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum))
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }
}
 */
package DSA.DP;

//given multiset of integers can be partitioned into two subsets such that the sum of the numbers on both subsets is equal or false otherwise
public class EqualSubsetsPartition {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println("Can partition? " + canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        // If total is odd, it cannot be partitioned into two equal subsets
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        // Use dynamic programming to find if there's a subset with sum == target
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // Update dp array: if dp[j] was true before considering num, then dp[j + num] should be true to
        // Iterate through the elements of the array
        for (int num : nums) {
            // Iterate from sum to 0 - reverse to ensure each number is only used once
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}


/*

//Approach - 2
public class PartitionEqualSubsetSumRecursive { //Using Recursion and DP
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Cannot partition if sum is odd
        if ((sum & 1) == 1) {
            return false;
        }

        sum /= 2;
        Boolean[][] memo = new Boolean[nums.length][sum + 1];
        return canPartitionRecursive(nums, 0, sum, memo);
    }

    private boolean canPartitionRecursive(int[] nums, int index, int target, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || index >= nums.length) {
            return false;
        }

        // Check memoized result
        if (memo[index][target] != null) {
            return memo[index][target];
        }

        // Include the current element in the subset or don't include it
        return memo[index][target] = canPartitionRecursive(nums, index + 1, target - nums[index], memo)
                      || canPartitionRecursive(nums, index + 1, target, memo);
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSumRecursive solver = new PartitionEqualSubsetSumRecursive();
        int[] nums = {1, 5, 11, 5};
        System.out.println("Can partition: " + solver.canPartition(nums));
        // Output: Can partition: true
    }
}
 */
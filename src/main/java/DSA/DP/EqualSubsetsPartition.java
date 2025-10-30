package DSA.DP;

//given multiset of integers can be partitioned into two subsets such that the sum of the numbers on both subsets is equal or false otherwise
public class EqualSubsetsPartition { //TC: O(n * target) where target = total / 2.

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println("Can partition? " + canPartition2(nums));
    }

    public boolean canPartition1(int[] nums) {  //Memoization
        int n = nums.length;
        if (n == 0) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // Cannot partition if sum is odd
        if ((sum & 1) == 1) {  //or sum % 2 != 0
            return false;
        }

        sum /= 2;
        Boolean[][] memo = new Boolean[n+1][sum+1];
        return canPartitionRecursive(nums, 0, sum, memo);  //we can go ascending order by using 0, or descending order by using n in method call
    }
    private boolean canPartitionRecursive(int[] nums, int index, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (target < 0 || index >= nums.length) return false;

        // Check memoized result
        if (memo[index][target] != null) {
            return memo[index][target];
        }

        // Include the current element in the subset or don't include it
        return memo[index][target] = canPartitionRecursive(nums, index + 1, target - nums[index], memo)
                || canPartitionRecursive(nums, index + 1, target, memo);
    }

    public static boolean canPartition2(int[] nums) {  //Tabulation
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        // If total is odd, it cannot be partitioned into two equal subsets
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        boolean[] dp = new boolean[target + 1]; //1D DP array dp[target + 1] where dp[i] means "Is there a subset with sum i?
        dp[0] = true;  //because the empty subset always sums to 0.

        for (int num : nums) {
            for (int j = target; j >= num; j--) { // Iterate in reverse to ensure each number is used only once
                dp[j] = dp[j] || dp[j - num]; // Either we already could make sum j, or now we can because we can add num to a previous subset sum (j - num).
            }
        }
        return dp[target];
    }
}

/*
DRY RUN:
Initial dp: [true, false, false, false, false, false, false, false, false, false, false, false]

num = 1
Loop j = 11 down to 1:
dp[1] = dp[1] || dp[0] = false || true → true
updated dp: [true, true, false, false, false, false, false, false, false, false, false, false]


num = 5
Loop j = 11 down to 5:
dp[5] = dp[5] || dp[0] = false || true → true
dp[6] = dp[6] || dp[1] = false || true → true
updated dp: [true, true, false, false, false, true, true, false, false, false, false, false]

num = 11
Loop j = 11 down to 11:
dp[11] = dp[11] || dp[0] = false || true → true
updated dp: [true, true, false, false, false, true, true, false, false, false, false, true]

num = 5
Loop j = 11 down to 5:
dp[10] = dp[10] || dp[5] = false || true → true
dp[11] = dp[11] || dp[6] = true || true → true (already true)
Final dp: [true, true, false, false, false, true, true, false, false, false, true, true]

return dp[target] => dp[11] = true
 */
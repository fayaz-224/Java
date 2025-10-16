package DSA.SlidingWindow;

//https://leetcode.com/problems/minimum-size-subarray-sum/description/
//return the minimal length of a subarray whose sum is greater than or equal to target
public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // expand window by including nums[right]

            // while window sum is large enough, try to shrink it
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left]; // remove the leftmost element
                left++;            // shrink from the left
            }
        }

        // if no valid subarray was found, return 0
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums)); // Output: 2 (The subarray [4,3] has the minimal length under the problem constraint.)
    }
}

package Array.Advance;

import java.util.Arrays;

//https://leetcode.com/problems/missing-number/
public class MissingNumber {
    public static int findMissing1(int[] nums) { // If starting from 0 or 1
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static int findMissing2(int[] nums) {  // If not starting from 0 or 1
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                return nums[i - 1] + 1;
            }
        }
        // If no gap, missing is after the last element
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        //start from 0
        int[] a1 = {3, 0, 1};
        System.out.println(findMissing1(a1));  // 2

        //Custom range ie, not starting from 0
        int[] a2 = {3, 4, 2, 6};
        System.out.println(findMissing2(a2)); // 5
    }
}

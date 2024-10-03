package Array.Advanced;

import java.util.Arrays;

public class SegregateEvenOdd {
    public static void segregate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // Move left pointer until it points to an odd number
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }

            // Move right pointer until it points to an even number
            while (left < right && nums[right] % 2 != 0) {
                right--;
            }

            // Swap nums[left] and nums[right]
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }

            // Sort even and odd segments separately
            Arrays.sort(nums, 0, left); // Even segment
            Arrays.sort(nums, left, nums.length); // Odd segment
        }
    }

    public static void main(String[] args) {
        int[] nums = {12, 34, 45, 9, 8, 90, 3};
        segregate(nums);  //op: 8 12 34 90 3 9 45

        System.out.println("Array after segregation:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}


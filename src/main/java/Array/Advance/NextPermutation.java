package Array.Advance;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        // Step 1: Find the first decreasing element index 'i' from the end where nums[i] < nums[i+1]
        for (int i = n - 2; i >= 0; i--) {  //i = n-2 is to avoid ArrayIndexOutOfBounds in next line
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // Step 2: If such index found, find the next greater element to swap with
        if (idx != -1) {
            for (int i = n - 1; i > idx; i--) {
                if (nums[i] > nums[idx]) {
                    swap(nums, i, idx);
                    break;
                }
            }
        }

        // Step 3: Reverse the subarray from idx+1 to end(n-1) to get next smallest sequence
        reverse(nums, idx+1);
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Original permutation: " + Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println("Next lexicographically greater permutation: " + Arrays.toString(nums));

        int[] nums2 = {3, 2, 1};
        System.out.println("Original permutation: " + Arrays.toString(nums2));
        nextPermutation(nums2);
        System.out.println("Next lexicographically greater permutation (returning to smallest): " + Arrays.toString(nums2));
    }
}

/*
Walkthrough
For nums = [1, 2, 3]:
Step 1: Find i = 1 (2 < 3), idx = 1
Step 2: Find i = 2 (3 > 2), swap -> [1, 3, 2]
Step 3: Reverse from i+1 = 2 to end (no effect in this example, see 5 digit example for ref) → [1, 3, 2]

For nums = [3, 2, 1]:
Step 1: No such i found → reverse entire array → [1, 2, 3]
 */
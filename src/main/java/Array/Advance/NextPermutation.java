package Array.Advance;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        // To find the break-point, we will traverse the array backward and store the index i
        // where; nums[i] < nums[i+1]
        for (int i = n - 2; i >= 0; i--) {  //i = n - 2 is to avoid ArrayIndexOutOfBounds in next line
            if(nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // If such a pair was found, look for the smallest number greater than nums[idx] from the end
        if (idx != -1) {
            for (int i = n - 1; i > idx; i--) {
                if (nums[i] > nums[idx]) {
                    swap(nums, i, idx);
                    break;
                }
            }
        }

        // Reverse the part of the array after idx to get the next smallest lexicographical order
        reverse(nums, idx + 1);  //idx + 1 as Follows: if we got result in above method this moves idx to end to avoid any other changes, if Not it'll reverse array from 0 index as idx=-1 initially.
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
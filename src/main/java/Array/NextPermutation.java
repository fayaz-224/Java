package Array;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        // To find the break-point, we will traverse the array backward and store the index i
        // where nums[i] < nums[i+1]
        int n = nums.length-1;
        int idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        //if Break point is found, then find the next largest index i greater than idx such that nums[k] < nums[l]
        // and swap them
        if (idx != -1) {
            for (int i = n - 1; i > idx; i--) {
                if (nums[i] > nums[idx]) {
                    swap(nums, i, idx);
                    break;
                }
            }
        }

        // If such a break-point does not exist i.e.the array is sorted in decreasing order, the given permutation is the last one in the sorted order of all possible permutations.
        // So, the next permutation must be the first i.e. the permutation in increasing order.
        //So, in this case, we will reverse the whole array and will return it as our answer.
        reverse(nums, idx);
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
    }
}
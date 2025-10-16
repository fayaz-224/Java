package DSA.BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FindFirstAndLastPositionInSortedArray {

        public static int[] searchRange(int[] nums, int target) {
            int left = binarySearch(nums, target, true);
            int right = binarySearch(nums, target, false);
            return new int[]{left, right};
        }

        private static int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
            int left = 0;
            int right = nums.length - 1;
            int idx = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    idx = mid;
                    if (isSearchingLeft) {
                        right = mid - 1; // move left to find earlier occurrence
                    } else {
                        left = mid + 1; // move right to find later occurrence
                    }
                }
            }

            return idx;
        }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
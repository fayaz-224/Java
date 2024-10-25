package DSA.BinarySearch;

//Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinInRotatedSortedArray {

    static int FindMin(int[] nums) {  //O(log n)
        int left = 0, right = nums.length - 1;
        while (left <right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

    public static void main(String args[]) {
        int[] arr = {3,4,5,1,2};
        int val = FindMin(arr);
        System.out.println("Min : "+val);
    }
}

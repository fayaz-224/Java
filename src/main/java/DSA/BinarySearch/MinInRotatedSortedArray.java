package DSA.BinarySearch;

//Given the sorted rotated array of unique elements, return the minimum element of this array.
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinInRotatedSortedArray {

    static int FindMin(int[] nums) {  //O(log n)
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {  // If mid-element is less than the rightmost, min is to the left
                right = mid;
            } else {
                left = mid + 1;  // Min is at mid or to the right
            }
        }
        return nums[left]; // Index of the smallest element (left) = rotation count
    }

    public static void main(String args[]) {
        int[] arr = {3,4,5,1,2};
        int val = FindMin(arr);
        System.out.println("Min : "+val);
    }
}

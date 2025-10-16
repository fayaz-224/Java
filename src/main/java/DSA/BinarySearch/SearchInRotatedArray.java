package DSA.BinarySearch;

//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(search2(arr, 5));
    }

    //Approach - 1
    static int search(int[] nums, int target) {
        int pivot = findPivot(nums); //to find max element in Rotated Sorted Array
        System.out.println(pivot);
        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1); // normal binary search
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target)
            return pivot;
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        } else {
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int findPivot(int[] arr) { // use this when arr doesn't contain duplicates
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    //Approach - 2
    static int search2(int[] nums, int target) {  //TC: O(logn)
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[left] <= nums[mid]) { //Left half
                if (nums[left] <= target && target < nums[mid]) {  //check if target is in this sorted left half
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            else {   // Right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
package Array.Advance;

//how many rotations we need to do to make the array sorted
public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(countRotations(arr));
    }

    //we can notice that the number of rotations is equal to the index of the minimum element
    static int countRotations(int arr[]) { //Approach 1
        int min = arr[0], min_index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static int countRotations2(int[] nums) {  //binary search
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid-element is less than the rightmost, min is to the left
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                // Min is at mid or to the right
                left = mid+1;
            }
        }
        return left;  // Index of the smallest element = rotation count
    }

//    static int countRotations(int[] arr) { //Approach 2
//        int pivot = findPivot(arr); //pivot is the max element
//        return pivot + 1;
//    }

    static int findPivot(int[] arr) { // use this for non duplicates
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) { //mid<end to avoid arrayIndexOutOfBounds error
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) { //mid>start to avoid arrayIndexOutOfBounds error
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {  //these 2 cond are optional, better to have in edge case scenarios
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int findPivotWithDuplicates(int[] arr) { // use this when arr contains duplicates
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

package Array;

public class SearchInMountainArray {

    static int search(int[] arr, int target) {
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBS(arr, target, 0, peak); //1st half from 0 -> peak
        if (firstTry != -1) {
            return firstTry;
        }
        return orderAgnosticBS(arr, target, peak+1, arr.length - 1); //2nd half from peak+1 -> end
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {  //we are in decreasing part
                end = mid;
            } else {  //we are in increasing part
                start = mid + 1;
            }
        }
        return start; // or return end as both are =
    }

    static int orderAgnosticBS(int[] arr, int target, int start, int end) {
        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) { //asc half
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) { //des half
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 12, 20, 9, 6, 2};
        int target = 7;
        System.out.println(search(arr, target));
    }
}

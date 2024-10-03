package DSA.BinarySearch;

//find an element in Infinite sorted array(assume we don't know the size of array - ie; we cant use size())
//binarySearch
public class InfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 17, 39, 63, 85, 90, 100, 130, 140, 160, 170};
        int target = 130;
        System.out.println("Element found at : " + ans(arr, target));
    }

    static int ans(int[] arr, int target) {
        // first find the range
        // first start with a box of size 2, as we shouldn't use range bounds for infinite array
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int temp = end + 1; // this is my new start
            // double the box value
            // end = previous end + sizeofbox * 2
            end = end + (end - start + 1) * 2; //end - start + 1 gives size of an array
            start = temp;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start)/2;

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
}

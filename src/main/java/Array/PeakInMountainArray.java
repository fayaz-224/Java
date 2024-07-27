package Array;

//Mountain Array = An array in which elements are in increasing and decreasing order like a mountain
// Ex: {1, 4, 7, 12, 9, 6, 2}
//Kunal Kushwaha
public class PeakInMountainArray {

    public static int peakIndexInMountainArray(int[] arr) { //O(logn) - binary search approach
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                // you are in dec part of array
                // this may be the ans, but look at left, this is why end != mid - 1
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        return start; // or return end as both are =
    }

    public static void main(String args[]) {
        int[] arr = {1, 3, 6, 9, 4, 2};
        int pos = peakIndexInMountainArray(arr);
        System.out.println("found at : "+pos);
    }
}

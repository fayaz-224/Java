package Sort;
import java.util.ArrayList;
import java.util.Arrays;

//Merge sort is more efficient and works faster than quick sort in case of larger array size or datasets.
// whereas Quick sort is more efficient and works faster than merge sort in case of smaller array size or datasets.
class MergeSort {

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2; // or int mid = l + (r - l) / 2; to avoid Space complexity if both l, r are big

            // Divide
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            // Merge by sorting
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int leftStart = low;      // starting index of left half of arr
        int rightStart = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner
        while (leftStart <= mid && rightStart <= high) {
            if (arr[leftStart] <= arr[rightStart]) {  //for sorting in descending, use if(L[i] >= <[j])
                temp.add(arr[leftStart]);
                leftStart++;
            } else {
                temp.add(arr[rightStart]);
                rightStart++;
            }
        }

        // if elements on the left half are still left
        while (leftStart <= mid) {
            temp.add(arr[leftStart]);
            leftStart++;
        }

        //  if elements on the right half are still left
        while (rightStart <= high) {
            temp.add(arr[rightStart]);
            rightStart++;
        }

        // transfering all elements from temporary to main arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7, 1, 0, 11 };
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array is");
        System.out.println(Arrays.toString(arr));
    }
}

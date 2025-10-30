package Array.Advance;

import java.util.ArrayList;

public class CountInversions {

    //BruteForce
    public static int countInversionsNaive(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    //Optimal - using mergeSort
    private static int mergeSortAndCount(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;

            count += mergeSortAndCount(arr, low, mid);  //left half
            count += mergeSortAndCount(arr, mid + 1, high);  //right half
            count += mergeAndCount(arr, low, mid, high);  //merge sorted halves
        }
        return count;
    }
    private static int mergeAndCount(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();  //we can use int[] as well
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        int cnt = 0;

        //storing elements in the temporary array in a sorted manner
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); //count inversions becoz arr[left] > arr[right]
                right++;
            }
        }

        // if elements on the left half are still left
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transferring all elements from temporary to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println("Number of inversions: " + countInversionsNaive(arr));

        System.out.println("Number of inversions: " + mergeSortAndCount(arr, 0, arr.length-1));
    }
}

package Array.Advance;

//Maximum of all subarrays of size K - find max element in each subarray of size k
public class SlidingMaximum {
    static void printKMax(int arr[], int k) {
        int j, max;
        int n = arr.length;
        for (int i = 0; i <= n - k; i++) {
            max = arr[i];
            for (j = 1; j < k; j++) { //k-1 times as we're already assuming arr[0] as max
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.print(max + " ");
        }
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3; //size of subarrays

        printKMax(arr, k);
    }
}
/*
Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
Output: 3 3 4 5 5 5 6
Explanation: Maximum of 1, 2, 3 is 3
             Maximum of 2, 3, 1 is 3
             Maximum of 3, 1, 4 is 4 etc..
 */
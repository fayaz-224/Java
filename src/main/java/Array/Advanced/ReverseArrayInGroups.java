package Array.Advanced;

import java.util.Arrays;

public class ReverseArrayInGroups {

    static void reverseInGroups(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i += k) {
            int left = i;  //set the left pointer as the current index
            int right = Math.min(i + k - 1, n - 1); //set the right pointer at a distance of group size(K)
                                                    //n-1 check, to handle case when k is not multiple of n or reached end of arr
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3; // group size

        System.out.println("Original array: " + Arrays.toString(arr));
        reverseInGroups(arr, k);
        System.out.println("Array after reversing in groups of " + k + ": " + Arrays.toString(arr));
    }
}

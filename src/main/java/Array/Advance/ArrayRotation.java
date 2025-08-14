package Array.Advance;

import java.util.Arrays;

class ArrayRotation {
    //Left Rotation
    public static void leftRotate(int arr[], int n, int d) {  //Approach - 1
        for (int i = 0; i < d; i++) {            // Rotate array 1 by 1 upto d times.
            int temp = arr[0];
            for (int j = 0; j < n - 1; j++) //n-1 becoz, in array index starts from 0. but, we are ignoring last digit which will get replaced by arr[0]
                arr[j] = arr[j + 1];
            arr[n - 1] = temp;
        }
    }
    public static void leftRotate2(int[] arr, int n, int d) {  //Approach - 2
        d = d % n; // In case d > n

        reverse(arr, 0, d - 1);       // Reverse first d elements
        reverse(arr, d, n - 1);       // Reverse remaining elements
        reverse(arr, 0, n - 1);       // Reverse the whole array
    }


    //right rotation
    public static void rightRotate(int arr[], int n, int d) {  //Approach - 1
        for (int i = 0; i < d; i++) {
            int temp = arr[n-1];
            for (int j = n-1; j > 0; j--)
                arr[j] = arr[j - 1];
            arr[0] = temp;
        }
    }
    public static void rightRotate2(int[] arr, int n, int d) {  //Approach - 2
        d = d % n; // Handle cases where d > n

        reverse(arr, 0, n - 1);        // Step 1: Reverse whole array
        reverse(arr, 0, d - 1);        // Step 2: Reverse first d elements
        reverse(arr, d, n - 1);        // Step 3: Reverse remaining elements
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
    
    public static void main(String[] args) {
        int arr[] = { 12, 10, 5, 6, 52, 36 };
        int n = arr.length;
        int d = 2; //no. of positions to shift
 
        leftRotate2(arr, n, d);
        System.out.println(Arrays.toString(arr));

        rightRotate2(arr, n, d);
        System.out.println(Arrays.toString(arr));
    }
}
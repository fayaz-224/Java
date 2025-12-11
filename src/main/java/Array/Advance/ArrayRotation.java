package Array.Advance;

import java.util.Arrays;

class ArrayRotation {

    //Left Rotation
    public static void leftRotate(int arr[], int n, int d) {  //Approach - 1 O(n*d)
        for (int i = 0; i < d; i++) {  // Rotate array 1 by 1 upto d times.
            int temp = arr[0];
            for (int j = 1; j < n; j++)
                arr[j-1] = arr[j];  //j-1 since we need to store from 0-index
            arr[n - 1] = temp;
        }
    }
    public static void leftRotate2(int[] arr, int n, int d) {  //Approach - 2 O(n)
        d = d % n; // In case d > n

        // Store first k elements
        int[] temp = Arrays.copyOfRange(arr, 0, d);

        // Shift remaining elements to the left
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        // Copy stored elements to the end
        for (int i = 0; i < d; i++) {
            arr[n - d + i] = temp[i];
        }
    }


    //right rotation
    public static void rightRotate(int arr[], int n, int d) {  //Approach - 1
        for (int i = 0; i < d; i++) {
            int temp = arr[n-1];
            for (int j = n-2; j >= 0; j--)
                arr[j+1] = arr[j];
            arr[0] = temp;
        }
    }
    public static void rightRotate2(int[] arr, int n, int d) {  //Approach - 2
        d = d % n; // Handle cases where d > n

        // Store last k elements
        int[] temp = Arrays.copyOfRange(arr, n - d, n);

        // Shift the remaining elements to the right
        for (int i = n-d-1; i >= 0; i--) {
            arr[i + d] = arr[i];
        }

        // Copy the stored elements to the front
        for (int i = 0; i < d; i++) {
            arr[i] = temp[i];
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
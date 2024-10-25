package Array.Advance;

import java.util.Arrays;

class ArrrayRotation {
    //Left Rotation/shift
    public static void leftRotate(int arr[], int n, int d) {
        for (int i = 0; i < d; i++) {            // Rotate array 1 by 1 upto d times.
            int temp = arr[0];	//left rotation
            for (int j = 0; j < n - 1; j++) //n-1 becoz, in array index starts from 0. but, we are ignoring last digit which will get replaced by arr[0]
                arr[j] = arr[j + 1];
            arr[n - 1] = temp;
        }
    }

    //right or cylindrical rotation
    public static void rightRotate(int arr[], int n, int d) {
        for (int i = 0; i < d; i++) {
            int temp = arr[n-1];
            for (int j = n-1; j > 0; j--)
                arr[j] = arr[j - 1];
            arr[0] = temp;
        }
    }
    
    public static void main(String[] args) {
        int arr[] = { 12, 10, 5, 6, 52, 36 };
        int n = arr.length;
        int d = 2; //no. of positions to shift
 
        leftRotate(arr, n, d);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        rightRotate(arr, n, d);
        System.out.println(Arrays.toString(arr));
    }
}
package Array.Basics;

import java.util.*;

//sort first half in increasing order and second half in decreasing
public class Sort_AscDes {
    static void sort1(Integer[] arr) {  //Approach-1
        int n = arr.length;
        Arrays.sort(arr, 0, n / 2); //1st half in ascending order
        Arrays.sort(arr, n / 2, n, Collections.reverseOrder());  //2nd half in descending order
    }

    static void sort2(int[] arr) { //Approach-2
        Arrays.sort(arr); //or impl bubble-sort
        int n = arr.length;
        int start=n/2;
        int end=n-1;
        while (start < end) {  //reverse 2nd half
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 5, 4, 6, 2, 1, 3, 8, 9, 7 };
        sort1(arr);
        System.out.printf("Modified arr[] : %s", Arrays.toString(arr));

        int[] a = { 5, 4, 6, 2, 1, 3, 8, 9, 7 };
        sort2(a);
        System.out.println("\nModified a[] : "+ Arrays.toString(a));
    }
}

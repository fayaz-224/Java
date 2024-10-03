package Array.Basics;

public class MaxMinElement {

    static int findLargestElement(int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) { //opposite way for smallest
                max= arr[i];
            }
        }
        return max;
    }

    static int findSmallestElement(int arr[]) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min= arr[i];
            }
        }
        return min;
    }

    static int secondLargest(int[] arr) {   //Approach 1
        int max = arr[0];
        int secMax = Integer.MIN_VALUE;
        for (int i = 0;i < arr.length;i++) {
            max = Math.max(max, arr[i]); //find largest element element
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secMax && arr[i] != max) {
                secMax = arr[i];
            }
        }
        return secMax;
    }

    static private int secondSmallest(int[] arr) { //Approach 2
        int n=arr.length;
        if (n < 2)
            return -1;

        int min = arr[0];
        int secMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                secMin = min;
                min = arr[i];
            } else if (arr[i] < secMin && arr[i] != min) {
                secMin = arr[i];
            }
        }
        return secMin;
    }

    public static void main(String args[]) {

        int arr[] =  {13,8,10,5,7,9,22,1};
        System.out.println("The Largest element in the array is: "+findLargestElement(arr));
        System.out.println("The Smallest element in the array is: "+findSmallestElement(arr));

        System.out.println("The 2nd Largest element in the array is: "+secondLargest(arr));
        System.out.println("The 2nd Smallest element in the array is: "+secondSmallest(arr));
    }
}

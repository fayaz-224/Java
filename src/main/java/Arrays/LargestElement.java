package Arrays;

public class LargestElement {

    static int findLargestElement(int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) { //opposite way for smallest
                max= arr[i];
            }
        }
        return max;
    }

    static int secondLargest(int[] arr) {   //Approach 1
        int max = arr[0];
        int secMax = -1;
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

        int small = arr[0];
        int second_small = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] < small) {
                second_small = small;
                small = arr[i];
            } else if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
        }
        return second_small;
    }

    public static void main(String args[]) {

        int arr1[] =  {2,5,1,3,0};
        System.out.println("The Largest element in the array is: "+findLargestElement(arr1));

        int arr2[] =  {8,10,5,7,9,22,1};
        System.out.println("The Largest element in the array is: "+findLargestElement(arr2));

        int arr3[] =  {13,8,10,5,7,9,22,1};
        System.out.println("The 2nd Largest element in the array is: "+secondLargest(arr3));
        System.out.println("The 2nd Smallest element in the array is: "+secondSmallest(arr3));
    }
}

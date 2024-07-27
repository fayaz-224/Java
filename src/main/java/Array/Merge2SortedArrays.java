package Array;

//without using extra space
public class Merge2SortedArrays { //Approach-1
    public static void mergeArrays(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1; // Index of last element in arr1
        int j = n - 1; // Index of last element in arr2
        int k = m + n - 1; // Index of last element in merged array

        // Merge elements from arr1 and arr2, starting from the end
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                k--;
                i--;
            } else {
                arr1[k] = arr2[j];
                k--;
                j--;
            }
        }

        // If there are remaining elements in arr2, copy them to arr1
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9, 0, 0, 0}; // Considering extra space at the end
        int[] arr2 = {2, 4, 6};
        int m = 5; // Number of elements in arr1
        int n = 3; // Number of elements in arr2

        mergeArrays(arr1, m, arr2, n);

        System.out.println("Merged Array:");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
    }
}


//Approach-2: we can also use InsertionSort logic to impl this.
/*
public class Merge2SortedArrays {  //Approach-3
    public static void merge(long[] arr1, long[] arr2, int n, int m) {

        // Declare 2 pointers
        int left = n - 1;
        int right = 0;

        // Swap the elements until arr1[left] is smaller than arr2[right]:
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        merge(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        for (int i = 0; i < n; i++) {  //arr1
            System.out.print(arr1[i] + " ");
        }
        for (int i = 0; i < m; i++) {  //arr2
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}

 */
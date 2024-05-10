package Sort;

//Insertion sort is a simple sorting algorithm that works by building a sorted array one element at a time.
// It is considered an “in-place” sorting algorithm, meaning it doesn’t require any additional memory space beyond the original array.
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};

        insertionSort(arr);

        System.out.println("Array after sorting:");
        printArray(arr);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {  //we start with 2nd element(arr[1]) of the array as 1st element(arr[0]) is assumed to be sorted.
            int key = arr[i];
            int j = i - 1;

            //Compare second element with the first element and if the second element is small then swap them.
            //Continue this process, comparing each element with the ones before it and swapping as needed to place it in the correct position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}


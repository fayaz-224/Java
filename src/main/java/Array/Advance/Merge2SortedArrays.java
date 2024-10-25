package Array.Advance;

//without using extra space
public class Merge2SortedArrays { //Approach-1
    public static void mergeArrays(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1; // Index of last element in arr1
        int j = n - 1; // Index of last element in arr2
        int k = m + n - 1; // Index of last element in merged array

        // Merge elements from arr1 and arr2, starting from the end
        //to avoid overwriting unmerged elements in arr1
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

        //sorting in descending order
//        for (int l = 0; l < arr1.length / 2; l++) {
//            int temp = arr1[l];
//            arr1[l] = arr1[arr1.length - 1 - l];
//            arr1[arr1.length - 1 - l] = temp;
//        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9, 0, 0, 0, 0}; // Considering extra space at the end
        int[] arr2 = {2, 4, 6, 8};
        int m = 5;
        int n = 4;

        mergeArrays(arr1, m, arr2, n);

        System.out.println("Merged Array:");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
    }
}


//Approach-2: we can also use InsertionSort logic to impl this.

/*
//Using extra space
public class Merge2SortedArrays {
public static int[] mergeAndSortDescending(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] merged = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            merged[k++] = arr1[i++];
        }

        while (j < n2) {
            merged[k++] = arr2[j++];
        }

        // Sort in descending order
        for (int l = 0; l < merged.length / 2; l++) {
            int temp = merged[l];
            merged[l] = merged[merged.length - 1 - l];
            merged[merged.length - 1 - l] = temp;
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] mergedDescending = mergeAndSortDescending(arr1, arr2);

        for (int num : mergedDescending) {
            System.out.print(num + " ");
        }
    }
}
 */
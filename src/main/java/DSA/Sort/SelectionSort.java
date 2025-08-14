package DSA.Sort;

import java.util.Arrays;

//Finds the smallest (or largest) element in the collection and put it in its proper place at the end of every iteration.
//swap the ith element with the smallest element, so we get smaller element in its position.
public class SelectionSort {
   public static void main(String args[]) {
       int n=6, i, j, temp;
       int[] arr = {4, 3, 7, 13, 0, 1};

       for(i = 0; i < n; i++) {
           for(j = i+1; j < n; j++) {
               if(arr[i] > arr[j]) {  //< for descending order
                   temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp;
               }
           }
       }
/*
//classic selection sort logic, where we do one swap at the end. In above logic we swap multiple times within the inner loop, which is less efficient, but produces correct output.
for (i = 0; i < n - 1; i++) {
    int minIdx = i;
    for (j = i + 1; j < n; j++) {
        if (arr[minIdx] > arr[j]) {
            minIdx = j;
        }
    }
    // Swap only once
    int temp = arr[i];
    arr[i] = arr[minIdx];
    arr[minIdx] = temp;
}
 */
       System.out.print("Array after Selection sort is :\n");
       System.out.println(Arrays.toString(arr));
   }
}  
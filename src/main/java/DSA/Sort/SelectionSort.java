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

       System.out.print("Array after Selection sort is :\n");
       System.out.println(Arrays.toString(arr));
   }
}  
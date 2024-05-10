package Sort;

import java.util.Arrays;

//Finds the smallest element in the collection and put it in its proper place at the end of every iteration
public class SelectionSort {
   public static void main(String args[]) {
       int n=6, i, j, temp;
       int[] arr = {4, 3, 7, 13, 0, 1};
         
       //main logic 
       for(i = 0; i < n; i++) {
           for(j = i+1; j < n; j++) {
               if(arr[i] > arr[j]) {  //at the end of inner loop, we'll get small no. in ith position
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
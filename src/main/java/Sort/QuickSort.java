package Sort;

import java.util.Arrays;

//Most efficient and optimized sorting technique. Uses divide and conquer strategy to sort the collection.
public class QuickSort {    //O(n^2)
     void quickSort(int[] arr, int start, int end) {
         int index = partition(arr, start, end); //index is pivot location
         
    	 if(start < index-1)
    		 quickSort(arr, start, index-1);
    	 if(index < end)
    		 quickSort(arr, index, end);
     }
     
     int partition(int[] arr, int start, int end) {
        int middle = (start + end) / 2;
        int pivot = arr[middle]; //take pivot element based on our req. ie, left, middle, right of the list
 
        int temp;
        while (start <= end) {
            while (arr[start] < pivot) //Check until all values on left are lower than pivot
                start++;

            while (arr[end] > pivot) //Check until all values on right are greater than pivot
                end--;
           
            if (start <= end) {
            	temp = arr[start]; //swap values becoz both conditions above failed means they are in incorrect position, then increment both sides.
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
		return start; //pivot index
    }
     
    public static void main(String[] args) {
    	QuickSort qs = new QuickSort();// no need of obj if we make methods as static
    	int[] arr = { 12, 13, 24, 10, 13, 3, 6, 90, 70, 10 };
 
    	qs.quickSort( arr, 0, arr.length-1);
     
    	System.out.println(Arrays.toString(arr));
    }
   
}
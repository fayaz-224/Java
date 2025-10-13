package DSA.Sort;

//Compares the current element to adjacent elements repeatedly.
//At the end of each iteration, the highest element gets bubbled up at its proper place (end).
class BubbleSort {
  public static void main(String []args) {
    int n=5, i, j, temp;
    int[] arr = {4, 7, 13, 0, 1};

    for (i = 0; i < n-1; i++) {  //n-1 to avoid indexOutOfBounds in below if cond. line 12
        for (j = 0; j < n-i-1; j++) {   //n-i-1 as last elements are already sorted
            if (arr[j] > arr[j+1]) {  // For descending order use '<' condition
              temp = arr[j];
              arr[j] = arr[j+1];
              arr[j+1] = temp;
            }
        }
    }
 
    System.out.println("Sorted list of numbers:");
    for (i = 0; i < n; i++)
      System.out.print(arr[i]+ " ");	//or
    
//    System.out.println("Sorted array: " + Arrays.toString(arr)); //Sorted array: [1, 2, 3, 4]
  }
}

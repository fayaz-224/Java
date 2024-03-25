package Sort;
import java.util.Scanner;

//Compares the current element to adjacent elements repeatedly.
//At the end of each iteration, the highest element gets bubbled up at its proper place.
 
class BubbleSort
{
  public static void main(String []args) 
  {
    int n, i, j, temp;
    Scanner s = new Scanner(System.in);
    System.out.println("number of integers to sort");
    n = s.nextInt();

    int arr[] = new int[n];
    System.out.println("Enter the no's");
    for (i = 0; i < n; i++)
      arr[i] = s.nextInt();
    
   // main logic 
    for (i = 0; i < n-1; i++)
    {
      for (j = 0; j < n-i-1; j++) //n-i-1 as last elements are already sorted
      {
        if (arr[j] > arr[j+1]) { // For descending order use '<' condition
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

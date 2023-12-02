package Sort;
import java.util.Scanner;

//Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half.
 
class BinarySearch	//the elements should be in ascending order i.e, sort
{
  public static void main(String args[])
  {
    int n=5, first, last, middle, key;
 
    Scanner s = new Scanner(System.in);
    int arr[] = new int[]{5,69,25,41,8};	//5 no's
    System.out.println("Enter key value to find");
    key = s.nextInt();
 
    first  = 0;
    last   = n - 1;
 
    while( first <= last )
    {
    	middle = (first + last)/2;
    	
      if ( arr[middle] < key )
        first = middle + 1;    
      else if ( arr[middle] == key )
      {
        System.out.println(key + " found at location " + (middle + 1) + ".");
        break;
      }
      else
         last = middle - 1;
   }
    
   if (first > last)
      System.out.println(key + " isn't present in the list.\n");
   
   s.close();
  }
}

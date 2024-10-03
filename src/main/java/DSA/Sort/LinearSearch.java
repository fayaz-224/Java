package DSA.Sort;
import java.util.Scanner;

class LinearSearch // array need not be sorted, like for binary search
{
   public static void main(String args[]) {
	    int i, n=7, key;  //n is no. of elements

	    Scanner s = new Scanner(System.in);
	    int arr[]=new int[n];
	    System.out.println("Enter those " + n + " elements");
	    for (i = 0; i < n; i++)
	      arr[i] = s.nextInt();

	    System.out.println("Enter key value to find");
	    key = s.nextInt();  
      
      for (i= 0; i < n; i++) {
         if (arr[i] == key) {
           System.out.println(key+" is present at location "+(i+1));
           break;
         }
      }
      if (i == arr.length)
        System.out.println(key + " doesn't exist in the array.");
   }
}

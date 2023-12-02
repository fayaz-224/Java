package Sort;
import java.util.Scanner;

//Finds the smallest element in the collection and put it in its proper place at the end of every iteration
  
public class SelectionSort 
{  
   public static void main(String args[])  
   {  
       int n, i, j, temp;  
       int arr[] = new int[50];  
       Scanner scan = new Scanner(System.in);  
         
       System.out.print("Enter Array Size : ");  
       n = scan.nextInt();  
         
       System.out.print("Enter Array Elements : ");  
       for(i=0; i<n; i++)  
       {  
           arr[i] = scan.nextInt();  
       }  
         
       //main logic 
       for(i=0; i<n; i++)  
       {  
           for(j=i+1; j<n; j++)  
           {  
               if(arr[i] > arr[j])  
               {  
                   temp = arr[i];  
                   arr[i] = arr[j];  
                   arr[j] = temp;  
               }  
           }  
       }  
         
       System.out.print("Array after Selection sort is :\n");  
       for(i=0; i<n; i++)  
       {  
           System.out.print(arr[i]+ "  ");  
       }  
   }  
}  
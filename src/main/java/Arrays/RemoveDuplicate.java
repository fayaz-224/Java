package Arrays;

public class RemoveDuplicate
{  
public static int removeDuplicateElements(int arr[], int n){
        if (n==0 || n==1){  
            return n;  
        }  
        int[] temp = new int[n];  
        int j = 0;  
        for (int i=0; i<n-1; i++){    //used if array is sorted. if not, sort array first
            if (arr[i] != arr[i+1]){  
                temp[j++] = arr[i];  
            }  
         }  
        temp[j++] = arr[n-1];     
        // Changing original array size 
        for (int i=0; i<j; i++){  
        	System.out.print(temp[i]+" ");
            }  
        return j;  
    }  
       
    public static void main (String[] args) {  
        int arr[] = {10,20,20,30,30,40,50,50};  
        int length = arr.length;  
        removeDuplicateElements(arr, length);  
        
    }  
}  


//This method can be used even if the array is not sorted.
//	Another Approach: 

//Take a Set 
//Insert all array elements in the Set. 
//Set does not allow duplicates and sets like LinkedHashSet maintains the order of insertion so it will remove duplicates 
//and elements will be printed in the same order in which it is inserted.


/*
import java.util.ArrayList;

public class RemoveDuplicate {
 
    static void findDuplicates(int arr[], int len)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
 
        for (int i = 0; i < len - 1; i++) {
                if (al.contains(arr[i])) {
                     continue;
                } else {
                     al.add(arr[i]);
                }
        }
        System.out.print(al + " ");
    }
 
    public static void main(String[] args){
 
        int arr[] = { 12, 11, 40, 12, 5, 6, 5, 12, 11 };
        int n = arr.length;
 
        findDuplicates(arr, n);
    }
}

*/
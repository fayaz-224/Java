package Arrays;
import java.util.*;

/*
public class DuplicateElements 
{  
public static void main(String[] args) {  

        int[] arr = new int[] {1, 3, 1, 4, 2, 7, 8, 8, 3};  
        System.out.println("Duplicate elements in given array: ");  
        
        //Searches for duplicate element  
        for(int i = 0; i < arr.length; i++) {  
            for(int j = i + 1; j < arr.length; j++) //time complexity : O(n*m)
            {  
                if(arr[i] == arr[j])  
                    System.out.println(arr[j]);  
            }  
        }  
    }  
} 
*/

 
public class DuplicateElements
{
    public static void main(String[] args)
    {
        int arr[] = {12, 11, 40, 12, 5, 6, 5, 12, 11};
        int n = arr.length;
        printDuplicates(arr, n);
    }

    private static void printDuplicates(int[] arr, int n) 
    {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        boolean dup = false;
        for(int i = 0; i < n; i++){	 //time complexity : O(n)
            if(map.containsKey(arr[i])){
                count = map.get(arr[i]);  //gives value of that key
                map.put(arr[i], count + 1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
         
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue() > 1){		// if this check is removed, we will get frequecy of all elements
                System.out.println(entry.getKey()+ " "+entry.getValue());
                dup = true;
            }
        }

        if(dup == false){
            System.out.println("No duplicates present in arrays");
        }
    }
}




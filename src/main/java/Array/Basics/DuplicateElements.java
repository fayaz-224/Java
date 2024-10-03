package Array.Basics;
import java.util.*;

/*
public class DuplicateElements {    //time complexity : O(n*m)
    public static void main(String[] args) {

        int[] arr = new int[] {1, 3, 1, 4, 2, 7, 8, 8, 3};  
        System.out.println("Duplicate elements in given array: ");  
        
        //Searches for duplicate element  
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j])  
                    System.out.println(arr[j]);  
            }  
        }  
    }  
} 
*/

 
public class DuplicateElements {
    public static void main(String[] args) {
        int arr[] = {12, 11, 40, 12, 5, 6, 5, 12, 11};
        int n = arr.length;
        printDuplicates(arr, n);
    }

    private static void printDuplicates(int[] arr, int n) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        boolean dup = false;

        for(int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//  --or--
//            if(map.containsKey(arr[i])) {
//                count = map.get(arr[i]);  //gives value of that key
//                map.put(arr[i], count + 1);
//            } else{
//                map.put(arr[i], 1);
//            }
        }
         
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1){		// if this check is removed, we will get frequency of all elements
                System.out.println(entry.getKey()+ " "+entry.getValue());
                dup = true;
            }
        }
        if(!dup){  //or dup == false
            System.out.println("No duplicates present in arrays");
        }
    }
}

/*
class TUF {
    static int findDuplicate(int[] arr) {
        int n = arr.length;
        int freq[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (freq[arr[i]] == 0) {
                freq[arr[i]] += 1;
            } else {
                System.out.println(arr[i]+" ");
            }
        }
        return 0;
    }
    public static void main(String args[]) {
        int arr[] = {1,3,4,2,3};
        System.out.println("The duplicate element is " + findDuplicate(arr));
    }
}
 */

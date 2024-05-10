package Array;

public class RemoveDuplicate { // array is sorted, if not sort it
    static int removeDuplicates(int[] arr) {
        int i = 0;  //imaginary index
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j]; //without using extra space
            }
        }
        return i + 1;
    }
       
    public static void main (String[] args) {
        int arr[] = {1,2,2,2,3,3};
        int k = removeDuplicates(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }  
}  


//This method can be used even if the array is not sorted.
//	Another Approach: 

//Take a Set 
//Insert all array elements in the Set. 
//Set does not allow duplicates and sets like "LinkedHashSet" maintains the order of insertion so it will remove duplicates
//and elements will be printed in the same order in which it is inserted.


/*
import java.util.ArrayList;

public class RemoveDuplicate {
 
    static void findDuplicates(int arr[], int len){
        ArrayList<Integer> al = new ArrayList<Integer>();
 
        for (int i = 0; i < len - 1; i++) {
            if (al.contains(arr[i]))
                 continue;
            else
                 al.add(arr[i]);
        }
        System.out.print(al + " ");
    }
 
    public static void main(String[] args) {
        int arr[] = { 12, 11, 40, 12, 5, 6, 5, 12, 11 };
        int n = arr.length;
 
        findDuplicates(arr, n);
    }
}

*/
package Array.Basics;

//Remove Duplicates
public class Duplicates2 {
    static int removeDuplicates(int[] arr) {
        //Arrays.sort(arr);  // array should be sorted, if not sort it
        int i = 0;  //imaginary index - 2 pointer
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j]; //without using extra space, directly update arr with non-duplicate element
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

//Approach-2:
//Take a Set, Insert all array elements in the Set.
//Set does not allow duplicates and sets like "LinkedHashSet" maintains the order of insertion.

/*
import java.util.ArrayList;
public class RemoveDuplicate {
 
    static void findDuplicates(int arr[], int len){
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
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
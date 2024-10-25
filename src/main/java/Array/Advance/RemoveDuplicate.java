package Array.Advance;

public class RemoveDuplicate { // array is sorted, if not sort it
    static int removeDuplicates(int[] arr) {
        int i = 0;  //imaginary index
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


//This method can be used even if the array is not sorted.
/*
public static void removeDuplicates(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] == array[j]) {
                    // Shift elements to the left to fill the gap, and replace duplicate values
                    for (int k = j; k < length - 1; k++) {
                        array[k] = array[k + 1];
                    }
                    // Decrement the length of the array and adjust loop variables
                    length--;
                    j--; //we need to do this, as replaced element might also be a duplicate
                }
            }
        }
        // Resize the array to remove the duplicates
        array = Arrays.copyOf(array, length);
    }
 */


//Approach-2:
//Take a Set, Insert all array elements in the Set.
//Set does not allow duplicates and sets like "LinkedHashSet" maintains the order of insertion.

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
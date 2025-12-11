package Array.Advance;

import java.util.*;

//The union of two arrays can be defined as the common and distinct elements in the two arrays without duplicates.
public class UnionOf2SortedArrays {

    public static List<Integer> findUnion(int[] arr1, int[] arr2) { //O( (m+n) log(m+n) )
        Set<Integer> st = new TreeSet<>(); //to maintain order

        for (int num : arr1) { // Insert elements from first array
            st.add(num);
        }
        for (int num : arr2) { // Insert elements from second array
            st.add(num);
        }

        return new ArrayList<>(st);
    }

    //2 pointer approach
    public static List<Integer> findUnion2(int[] arr1, int[] arr2, int n, int m) {  //Optimal - O(m+n)
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                addIfNotDuplicate(result, arr1[i]);
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                addIfNotDuplicate(result, arr2[j]);
                j++;
            }
            else {
                addIfNotDuplicate(result, arr1[i]);
                i++;
                j++;
            }
        }

        while (i < n) {
            addIfNotDuplicate(result, arr1[i]);
            i++;
        }
        while (j < m) {
            addIfNotDuplicate(result, arr2[j]);
            j++;
        }

        return result;
    }
    private static void addIfNotDuplicate(List<Integer> list, int val) {
        if (list.isEmpty() || list.get(list.size() - 1) != val)  //checking only with last val in list because, arrays are in sorted order So the only possible duplicate must be the immediately previous value.
            list.add(val);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5, 12};

        List<Integer> result = findUnion(arr1, arr2);
        System.out.print("Union of arr1 and arr2 is: "+ result);
    }
}

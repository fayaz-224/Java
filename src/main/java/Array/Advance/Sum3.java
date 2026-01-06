package Array.Advance;

import java.util.*;

public class Sum3 {
    //Brute Force Approach - O(N^3)
    public static List<List<Integer>> triplet1(int[] arr, int n) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {    //target = 0
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(temp);  //we need this, becoz there's a chance to get duplicated result
                        set.add(temp);
                    }
                }
            }
        }
       // convert back to list
       return  new ArrayList<>(set);
    }

    //Better Approach - O(N^2)
    public static List<List<Integer>> triplet2(int[] arr, int n) {  //target = 0
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < n; j++) {

                int third = -(arr[i] + arr[j]); //Calculate the 3rd element:

                //Find the element in the set:
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashset.add(arr[j]);
            }
        }

        // store the set elements in the answer:
        return new ArrayList<>(st);
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4};
        int n = arr.length;
        System.out.println(triplet2(arr, n));
    }
}


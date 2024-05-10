package Basics;

import java.util.*;

//Brute Force Approach
public class Sum3 {
    public static List<List<Integer>> triplet(int[] arr, int n) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {    //target = 0
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        //Collections.sort(temp);
                        temp.sort(Integer::compareTo); //we need this, becoz there's a chance to get duplicated result
                        set.add(temp);
                    }
                }
            }
        }

        // convert back to list
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4};
        int n = arr.length;
        List<List<Integer>> ans = triplet(arr, n);
        System.out.println(ans.stream().toList());
    }
}


/*
//Better Approach
public static List<List<Integer>> triplet(int n, int[] arr) {
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
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
 */
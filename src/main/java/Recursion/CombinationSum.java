package Recursion;

import java.util.*;

//Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.
class CombinationSum {
    static List<List<Integer>> ans = new ArrayList<>();
    static List<List<Integer>> ans2 = new ArrayList<>();
    private static void findCombinations(int ind, int[] arr, int target, List<Integer> ds) {
        if (ind == arr.length) { //if it reaches end of arr
            if (target == 0) {  //and target is '0' - we got the req combination
                ans.add(new ArrayList<>(ds));
            }
            return ;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target-arr[ind], ds);  //pick
            ds.remove(ds.size() - 1);  //After recursive call completed in above line -Backtrack, we should remove previously added element in line 16
        }
        findCombinations(ind + 1, arr, target, ds);  //Not pick
    }

    //use this if each number in candidates may only be used once in the combination.
    private static void findCombinations2(int ind, int[] arr, int target, List<Integer> ds) {
        if (target == 0) {
            ans2.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations2(i + 1, arr, target - arr[i], ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        findCombinations(0, arr, target, new ArrayList<>());
        System.out.println("Combinations are: " + ans);

        int[] arr2 = {1,1,2,5,6,7,10};
        Arrays.sort(arr2);
        findCombinations2(0, arr2, target, new ArrayList<>());
        System.out.println("Combinations are: " + ans2);

//        for (int i = 0; i < ls.size(); i++) {
//            for (int j = 0; j < ls.get(i).size(); j++)
//                System.out.print(ls.get(i).get(j) + " ");
//            System.out.println();
//        }
    }
}

package Recursion;

import java.util.*;

//Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.
class CombinationSum {
    static List<List<Integer>> ans = new ArrayList<>();
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

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;

        findCombinations(0, arr, target, new ArrayList<>());
        System.out.println("Combinations are: " + ans);

//        for (int i = 0; i < ls.size(); i++) {
//            for (int j = 0; j < ls.get(i).size(); j++) {
//                System.out.print(ls.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
    }
}

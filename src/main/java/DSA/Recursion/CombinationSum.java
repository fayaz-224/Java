package DSA.Recursion;

import java.util.*;

//Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.
class CombinationSum { //dfs

    static List<List<Integer>> ans = new ArrayList<>();
    private static void findCombinations(int idx, int[] arr, int target, List<Integer> ds) {
        if (idx == arr.length) { //if it reaches end of arr
            if (target == 0) {  //and target is '0' - we got the req combination
                ans.add(new ArrayList<>(ds));
            }
            return ;
        }

        if (arr[idx] <= target) {
            ds.add(arr[idx]);
            findCombinations(idx, arr, target-arr[idx], ds);  //pick
            ds.remove(ds.size() - 1);  //After recursive call completed in above line -Backtrack, we should remove previously added element in line 18
        }
        findCombinations(idx + 1, arr, target, ds);  //Not pick
    }

    //use this if each number in candidates may only be used once in the combination.
    static List<List<Integer>> ans2 = new ArrayList<>();
    private static void findCombinations2(int idx, int[] arr, int target, List<Integer> ds) {
        if (idx == arr.length){
            if (target == 0) {
                ans2.add(new ArrayList<>(ds));
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;  //for skipping duplicate combinations.
            if (arr[i] > target) break;  //Since array is sorted, if arr[i] > target, all next numbers will also be too big → stop early (optimization).

            ds.add(arr[i]);
            findCombinations2(i + 1, arr, target - arr[i], ds);
            ds.remove(ds.size() - 1);
            //not pick is not needed  - for loop already moves to the next index on every iteration (i + 1), and the skip condition
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        findCombinations(0, arr, target, new ArrayList<>());  //for inputs Sorting is recommended, but not required for Combination Sum I
        System.out.println("Combinations are: " + ans);

        int[] arr2 = {2,3,6,7};
        findCombinations2(0, arr2, target, new ArrayList<>()); //input should be sorted to ensure duplicates are skipped correctly and results are unique for Combination Sum II
        System.out.println("Combinations are: " + ans2);

//        for (int i = 0; i < ls.size(); i++) {
//            for (int j = 0; j < ls.get(i).size(); j++)
//                System.out.print(ls.get(i).get(j) + " ");
//            System.out.println();
//        }
    }
}

/*
Combination Sum I needs not-pick because you're making a binary decision per index (pick or not pick).

Combination Sum II handles everything in a for loop, skipping duplicates and always moving forward — so there's no need for a separate not-pick.
 */
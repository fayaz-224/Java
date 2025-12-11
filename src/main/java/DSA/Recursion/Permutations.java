package DSA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Backtracking
//https://leetcode.com/problems/permutations/description/
public class Permutations {

    //for String
    static List<String> permutation = new ArrayList<>();
    public static void printPermutationForString(String str, String perm) {
        if (str.isEmpty()) {
            permutation.add(perm);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String remainingStr = str.substring(0, i) + str.substring(i + 1); //In str.substring(0, i), i is exclusive ie; remove the used char from string
            printPermutationForString(remainingStr, perm + currChar);
        }
    }

    //for int[]
    public static List<List<Integer>> printPermutationForInt(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, list, new ArrayList<>());
        return list;
    }
    private static void backtrack(int [] nums, List<List<Integer>> result, List<Integer> currList) {
        if (currList.size() == nums.length) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (currList.contains(nums[i])) continue; // element already exists, skip
            currList.add(nums[i]);
            backtrack(nums, result, currList);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        printPermutationForString(str, "");
        System.out.println("Total permutations of string:" + permutation.size());
        System.out.println(Arrays.toString(permutation.toArray()));

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = printPermutationForInt(nums);
        System.out.println("Total permutations of int[]: " + res.size());
        for (List<Integer> permutation : res) {
            System.out.println(permutation);
        }
    }
}

/*- //for string input
Iteration 1: i = 0
    currChar = 'A'
    newStr = str.substring(0, 0) + str.substring(0 + 1)
    newStr = "" + "BC" = "BC"
    Recursively call printPermutation("BC", "A")
Iteration 2: i = 0
    currChar = 'B'
    newStr = str.substring(0, 0) + str.substring(0 + 1)
    newStr = "" + "C" = "C"
    Recursively call printPermutation("C", "AB")
Iteration 3: i = 0
    currChar = 'C'
    newStr = str.substring(0, 0) + str.substring(0 + 1)
    newStr = "" + "" = ""
    The base case is reached because str.isEmpty() is true. So, it prints "ABC" and increments the count.
Now Backtracking to the all remaining calls for i: 0 -> n
 */

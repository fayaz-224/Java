package Recursion;

import java.util.ArrayList;
import java.util.List;

//Backtracking
/*
public class Permutations { //permutaions = n! but not always
    static int count = 0;
    public static void printPermutation(String str, String perm) {
        if (str.isEmpty()) {
            System.out.println(perm); //this will print all the permutations
            count++;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1); //In str.substring(0, i), i is exclusive
            printPermutation(newStr, perm + currChar);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        printPermutation(str, "");
        System.out.println("Total permutations:" + count);
    }
}
*/
/*
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



public class Permutations {  //for int[] input

    static List<String> permutation = new ArrayList<>();
    public static List<String> printPermutation(int[] nums, StringBuilder perm) {
        if (perm.length() == nums.length) {
            permutation.add(perm.toString());
        }

        for (int i = 0; i < nums.length; i++) {
            if (perm.indexOf(String.valueOf(nums[i])) != -1) {
                continue; // Skip if the digit is already in permutation
            }
            perm.append(nums[i]);
            printPermutation(nums, perm);
            perm.deleteCharAt(perm.length()-1); // After the recursive call returns, we backtrack by removing the last digit (i) from the permutation (perm = "").
        }
        return permutation;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<String> res = printPermutation(nums, new StringBuilder());
        for (String permutation : res) {
            System.out.println(permutation);
        }
        System.out.println("Total permutations: " + res.size());
    }
}

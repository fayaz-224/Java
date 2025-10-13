package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

//Backtracking
public class Permutations { //permutations = n! but not always

    static int count = 0;
    public static void printPermutationForString(String str, String perm) {
        if (str.isEmpty()) {
            System.out.println(perm); //this will print the permutations or add to List as below example
            count++;
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String remainingStr = str.substring(0, i) + str.substring(i + 1); //In str.substring(0, i), i is exclusive ie; remove the used char from string
            printPermutationForString(remainingStr, perm + currChar);
        }
    }

    static List<String> permutation = new ArrayList<>();
    public static void printPermutationForInt(int[] nums, StringBuilder perm) {
        if (perm.length() == nums.length) {
            permutation.add(perm.toString());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (perm.indexOf(String.valueOf(nums[i])) != -1) {  //Don’t use indexOf if the input string may contain duplicate characters. use visited[] array logic
                continue; // Skip if the digit is already in permutation
            }
            perm.append(nums[i]);
            printPermutationForInt(nums, perm);
            perm.deleteCharAt(perm.length()-1); // After the recursive call returns, we backtrack by removing the last digit (i) from the permutation (perm = "").
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        printPermutationForString(str, "");
        System.out.println("Total permutations of string:" + count);

        int[] nums = {1, 2, 3};
        printPermutationForInt(nums, new StringBuilder());
        System.out.println("Total permutations of int[]: " + permutation.size());
        for (String permutation : permutation) {
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

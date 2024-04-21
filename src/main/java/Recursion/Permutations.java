package Recursion;

//Backtracking
public class Permutations { //permutaions = n! but not always
    static int count=0;
    public static void printPermutation(String str, String perm) {
        if (str.isEmpty()) {
            System.out.println(perm); //this will print all the permutations
            count++;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPermutation(newStr, perm + currChar);
        }
    }

    public static void main(String[] args) {
        String str = "ABCD";
        printPermutation(str, "");
        System.out.println("Total permutations:" + count);
    }
}


/*
import java.util.ArrayList;
import java.util.List;

public class Permutations {  //for int[] input

    static List<String> permutations = new ArrayList<>();
    public static List<String> printPermutation(int[] nums, StringBuilder perm) {
        if (perm.length() == nums.length) {
            permutations.add(perm.toString());
        }

        for (int i = 0; i < nums.length; i++) {
            if (perm.indexOf(String.valueOf(nums[i])) != -1) {
                continue; // Skip if the digit is already in permutation
            }
            perm.append(nums[i]);
            printPermutation(nums, perm);
            perm.deleteCharAt(perm.length() - 1);
        }
        return permutations;
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
*/
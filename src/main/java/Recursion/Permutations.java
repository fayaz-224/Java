package Recursion;

//Backtracking
public class Permutations { //permutaions = n! but not always
    static int count=0;
    public static void printPermutation(String str, String perm) {
        if (str.isEmpty()) {
            System.out.println(perm); //this will print all the permutations
            count++;
            return;
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

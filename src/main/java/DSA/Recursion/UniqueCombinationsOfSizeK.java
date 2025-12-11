package DSA.Recursion;

import java.util.HashSet;
import java.util.Set;

public class UniqueCombinationsOfSizeK {

    public static Set<String> getUniqueCombinations(String input, int k) {
        Set<String> result = new HashSet<>();
        backtrack(input, k, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String s, int k, int index, StringBuilder path, Set<String> result) {
        if (path.length() == k) {
            result.add(path.toString());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            path.append(s.charAt(i));
            backtrack(s, k, i + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String args[]) {
        String s = "abbccde";

        System.out.println("combinations: "+ getUniqueCombinations(s, 2));
    }
}

package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private static List<String> generateParentheses(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return result;
        }

        if (open < max) {
            generateParentheses(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            generateParentheses(result, current + ")", open, close + 1, max);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3; // Number of pairs of parentheses
        List<String> result = new ArrayList<>();
        List<String> results = generateParentheses(result, "", 0, 0, n);
        System.out.println("Valid combinations of parentheses: " + results.size());
        for (String str : results) {
            System.out.println(str);  //5 -> ((())), (()()), (())(), ()(()), ()()()
        }
    }
}
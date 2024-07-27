package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    static List<String> result = new ArrayList<>();
    private static void generateParentheses(String current, int open, int close, int max) {
        if (current.length() == max * 2) {  //3 open, 3 close parenthesis = max*2
            result.add(current);
            return;
        }
        //Depth-First Search or DFS algorithm is a recursive algorithm that uses the backtracking principle.
        if (open < max) {
            generateParentheses(current + "(", open + 1, close, max);
        }
        if (close < open) {
            generateParentheses(current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3; // Number of pairs of parentheses
        generateParentheses("", 0, 0, n);
        System.out.println("Valid combinations of parentheses:" + result.size());
        for (String str : result) {
            System.out.println(str);
        }
    }
}

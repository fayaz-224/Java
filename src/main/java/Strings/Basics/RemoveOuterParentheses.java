package Strings.Basics;

//Given a valid parentheses string s, your task is to remove the outermost parentheses from every primitive component of s and return the resulting string.
class RemoveOuterParentheses {

    static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();

        int level = 0; // Initialize nesting level counter

        for (char ch : s.toCharArray()) {
            // If we encounter '(', increase the level
            if (ch == '(') {
                // If we're inside a primitive, add '(' to result
                if (level > 0)
                    result.append(ch);

                level++;
            }
            // If we encounter ')', decrease the level
            else if (ch == ')') {
                level--;

                // If we're inside a primitive, add ')' to result
                if (level > 0)
                    result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())";

        System.out.println("The result is: " + removeOuterParentheses(s));
    }
}

/*
Input:
 s = "((()))"
Output:
 "(())"
Explanation:
 The input string is a single primitive: "((()))".
Removing the outermost layer yields: "(())".

Input:
 s = "()(()())(())"
Output:
 "(()())()"
Explanation:
 Primitive decomposition: "()" + "(()())" + "(())"
After removing outermost parentheses: "" + "()()" + "()"
Final result: "()()()".
 */
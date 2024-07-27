package Strings;

import java.util.Scanner;
import java.util.Stack;

class ValidParanthesis {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>(); //we can use deque aswell
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
                st.push(s.charAt(i));
            else if(s.charAt(i) ==')')
                if (!st.empty() && st.peek() == '(')
                    st.pop();
                else
                    return false;
            else if(s.charAt(i) ==']')
                if (st.empty() || st.pop() != '[')     //simple way to return false directly
                    return false;
            else if(s.charAt(i) =='}')
                if (st.empty() || st.pop() != '{')     //simple way to return false directly
                    return false;
        }
        return st.empty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (isValid(str))
            System.out.println("Valid");
        else
            System.out.println("InValid");
    }
}


/*
public static boolean isValid(String s) {
    HashMap<Character, Character> bracketMap = new HashMap<>();
    bracketMap.put(')', '(');
    bracketMap.put(']', '[');
    bracketMap.put('}', '{');

    Deque<Character> stack = new ArrayDeque<>(); //or use stack

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (bracketMap.containsValue(ch)) {
            stack.push(ch);
        } else if (bracketMap.containsKey(ch)) {
            if (stack.isEmpty() || stack.peek() != bracketMap.get(ch)) {
                return false;
            }
        }
    }

    return stack.isEmpty();
}
 */
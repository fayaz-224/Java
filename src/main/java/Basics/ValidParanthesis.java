package Basics;

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
                if (!st.empty() && st.peek() == '[')
                    st.pop();
                else
                    return false;
            else if(s.charAt(i) =='}')
                if (!st.empty() && st.peek() == '{')
                    st.pop();
                else
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

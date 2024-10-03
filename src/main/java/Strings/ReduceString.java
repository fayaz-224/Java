package Strings;

import java.util.Stack;

public class ReduceString {

    static String stringReduction(String s, int k) {
        Stack<CharCount> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == ch) {
                stack.push(new CharCount(ch, stack.peek().count++));
                if (stack.peek().count == 3) {
                    stack.pop();
                }
            } else {
                stack.push(new CharCount(ch, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(CharCount c: stack){
            for(int i=0;i<c.count;i++)
                sb.append(c.c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "qddxxxd";  //op: q
        int k=3;
        System.out.println(stringReduction(s1, k));
    }
}

class CharCount{
    char c;
    int count;
    public CharCount(char c, int count) {
        this.c = c;
        this.count = count;
    }
}
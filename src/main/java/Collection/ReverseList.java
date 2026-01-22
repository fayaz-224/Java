package Collection;

import java.util.Arrays;
import java.util.Stack;

public class ReverseList {
    static Stack<Integer> reverse(Stack<Integer> s) {  //ArrayList or Stack
        int start =0;
        int end=s.size()-1;

        while(start < end){
            int temp = s.get(start);
            s.set(start, s.get(end));
            s.set(end, temp);
            start++;
            end--;
        }
        return s;
    }

    public static void main(String[] args){
        Stack<Integer> list = new Stack<>();
        list.addAll(Arrays.asList(1, 5, 7, 3));
        System.out.println(reverse(list));
    }
}

package Strings;

import java.util.HashMap;
import java.util.Map;

public class MaxOccuranceOfChar {

    private static char maxChar(String s) {
        char ans = 0;
        int count=0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);

            if(count < map.get(c))
                ans = c;
        }

        return ans;
    }

    public static void main(String args[]){
        String s = "fayazzaa";
        System.out.println("max occurring char: " + maxChar(s));
    }
}

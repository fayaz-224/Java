package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Longest Substring without repeating characters - sliding window model
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcdabcbb";
        String result = lengthOfLongestSubstring(s);
        System.out.println("longest substring without repeating characters:" + result);
        System.out.println("Length of the longest substring: " + result.length());

        int res = solve(s);
        System.out.println(res);
    }

    public static String lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "String is empty.";
        }

        int maxLength = 0;  //gives count of longest substring
        int start = 0;
        int longestStart = 0;  //starting index of longest substring of maxLength
        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {  // If this character is seen before, then update start
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);  // Update the last occurrence of the current character

            //maxLength = Math.max(maxLength, end - start + 1);   //use if we need only length of largest subString
            if (end - start + 1 > maxLength) {  //take largest subString
                maxLength = end - start + 1;
                longestStart = start;
            }
        }

        //return maxLength;
        return s.substring(longestStart, longestStart + maxLength);
    }

    //Brute force Approach
    static int solve(String str) {

        if(str.isEmpty())
            return 0;
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) // outer loop for traversing the string
        {
            Set< Character > set = new HashSet<>();
            for (int j = i; j < str.length(); j++) {    // nested loop for getting different string starting with str[i]
                if (set.contains(str.charAt(j))) {  // if element is found so mark it as ans and break from the loop
                    maxans = Math.max(maxans, j-i);  //j-i only as we dont need to include current char(+1) as its a repeated one
                    break;
                }
                set.add(str.charAt(j));
            }
        }
        return maxans;
    }
}

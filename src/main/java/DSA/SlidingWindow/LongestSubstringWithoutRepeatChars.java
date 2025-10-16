package DSA.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//sliding window model
public class LongestSubstringWithoutRepeatChars {
    public static void main(String[] args) {
        String s = "abcdabcbb";
        System.out.println("longest substring without repeating characters: " + longestSubstring(s));
        System.out.println("Length: " + longestSubstring(s).length());
    }

    static String longestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "String is empty.";
        }

        int maxLength = 0;  //gives count of longest substring
        int left = 0;
        int start = 0;  //start index of longest valid substring
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)  && map.get(c) >= left) {  // If this character is seen before, then move left to the right of that previous occurrence.
                left = map.get(c) + 1;
            }
            map.put(c, right);  // Update the last occurrence of the current character

            if (right - left + 1 > maxLength) {  //take longest unique subString
                maxLength = right - left + 1;
                start = left;
            }
        }

        //gives string as result, then calculate string length() to find longest substring length if needed
        return s.substring(start, start + maxLength);
    }

    //Brute force Approach
    static int solve(String str) {
        if(str.isEmpty()) return 0;

        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            Set< Character > set = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
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

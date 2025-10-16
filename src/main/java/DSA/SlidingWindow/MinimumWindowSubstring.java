package DSA.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/description/
//Find the minimum window substring of a string such that every character in target (including duplicates) is included in the window.
//Approach — Sliding Window + HashMap
public class MinimumWindowSubstring {

    static String minWindow(String s, String t) { //TC: O(s+t)
        if (s.length() < t.length()) return "";

        //frequency map of t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int start = -1;  // start index of min window
        int needed = t.length();  // total characters we still need to include
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (tMap.containsKey(ch)) {
                if (tMap.get(ch) > 0) { // Check if this character was still needed
                    needed--;
                }
                tMap.put(ch, tMap.get(ch) - 1); // Decrement frequency as we used it
            }

            //Now Shrink the window from the left to make it as small as possible while still valid (ie; needed=0)
            while (needed == 0) {
                if (right - left + 1 < minLen) {  // update minimum window if smaller window found
                    minLen = right - left + 1;
                    start = left;
                }

                // try to remove the leftmost character
                char leftChar = s.charAt(left);
                if (tMap.containsKey(leftChar)) {
                    tMap.put(leftChar, tMap.get(leftChar) + 1);
                    //If the frequency becomes positive (>0), it means this character is now missing from the window, so increment needed
                    if (tMap.get(leftChar) > 0) {
                        needed++;
                    }
                }
                left++; // move window as we don't need this char
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("result: "+ minWindow(s, t)); //BANC
    }
}

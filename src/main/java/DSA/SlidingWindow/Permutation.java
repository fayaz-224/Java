package DSA.SlidingWindow;

import java.util.*;

//Check if s2 contains a permutation of s1.
//https://leetcode.com/problems/permutation-in-string/description/
public class Permutation {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Build frequency map for s1
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // Shrink window if it exceeds s1's length
            if (right - left + 1 > s1.length()) {
                char leftChar = s2.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar); // clean up
                }
                left++;
            }

            // Compare maps
            if (windowMap.equals(s1Map)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Permutation sol = new Permutation();
        System.out.println(sol.checkInclusion("ab", "eidbaooo")); // true (s2 contains one permutation of s1 ("ba"))
        System.out.println(sol.checkInclusion("ab", "eidboaoo")); // false
    }
}

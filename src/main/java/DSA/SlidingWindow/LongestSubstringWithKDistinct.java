package DSA.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//sliding window technique with two pointers (left, right)
//return the length of the longest substring that contains at most k distinct characters.
public class LongestSubstringWithKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();  //character → frequency within the current window.
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) { //Expand the Right Pointer
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If window has more than k distinct characters, shrink it from left Pointer if invalid
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            // Update max window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithKDistinct sol = new LongestSubstringWithKDistinct();
        System.out.println(sol.lengthOfLongestSubstringKDistinct("eceba", 2)); // Output: 3 (substring "ece")
        System.out.println(sol.lengthOfLongestSubstringKDistinct("aa", 1));    // Output: 2
    }
}

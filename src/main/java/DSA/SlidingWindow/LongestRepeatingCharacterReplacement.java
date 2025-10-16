package DSA.SlidingWindow;

import java.util.HashMap;

//https://leetcode.com/problems/longest-repeating-character-replacement/description/
//You can choose any character of the string and change it to any other character. You can perform this operation at most k times.
public class LongestRepeatingCharacterReplacement {
    static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freqs = new HashMap<>();
        int res = 0, i = 0, maxFreq = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqs.get(c)); // Checking the character with max number of occurrence

            while ((j - i + 1) - maxFreq > k) {  //shrink if replacements is more than allowed (k)
                char left = s.charAt(i);
                freqs.put(left, freqs.get(left) - 1);
                i++;
            }

            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k)); //4
    }
}
package Strings.Advanced;

import java.util.Arrays;

//https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }

    //O(n log n)
    //After sort all strings that share a common prefix will be grouped together. The first and last strings in the sorted order will have the maximum possible difference.
    static String longestCommonPrefix(String[] st) {
        StringBuilder ans = new StringBuilder();

        Arrays.sort(st);
        String first = st[0];
        String last = st[st.length - 1];

        // Compare characters of the first and last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) { // Stop if characters are different
                return ans.toString();
            }

            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    //Horizontal Scanning - O(n × m) - faster than O(n logn)
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Start with the first string as prefix & compare with remaining
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Shrink prefix until it matches the start of current string
            while (!strs[i].startsWith(prefix)) {  //or strs[i].indexOf(prefix) != 0
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}

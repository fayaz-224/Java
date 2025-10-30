package Strings.Advanced;

//https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }

    //Approach: 1 - Binary Search - O(n × m × log m) - Use for very large inputs/strings
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        // Find the minimum length among all strings
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        int low = 1, high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1; // try for a longer prefix
            } else {
                high = mid - 1; // try shorter prefix
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }
    private static boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) return false;
        }
        return true;
    }

    //Approach: 2 - Horizontal Scanning - O(n × m) - Use for short strings/input
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Start with the first string as prefix
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

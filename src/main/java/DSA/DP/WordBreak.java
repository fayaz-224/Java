package DSA.DP;

import java.util.*;

//https://leetcode.com/problems/word-break/description/
class WordBreak {

    static boolean validateWord(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // For O(1) lookup
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true; //Base case: empty string is segmentable

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If substring s[j:i] is a valid word and dp[j] is true → mark dp[i] = true
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further splits
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String word = "applepenapple";
        List<String> dict = List.of("apple","pen");
        System.out.println(validateWord(word, dict));  //true; because "applepenapple" can be segmented as "apple pen apple".

    }
}

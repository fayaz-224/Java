package Strings.Advanced;

import java.util.Arrays;

//find the minimum number of insertions needed to make it a palindrome.
public class MinInsertionsForPalindrome {

    //Recursion + Memoization — O(n²)
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(s, 0, n - 1, dp);
    }
    private int solve(String s, int l, int r, int[][] dp) {
        if (l >= r) return 0;
        if (dp[l][r] != -1) return dp[l][r];

        if (s.charAt(l) == s.charAt(r))
            return dp[l][r] = solve(s, l + 1, r - 1, dp);

        return dp[l][r] = 1 + Math.min(
                solve(s, l + 1, r, dp),
                solve(s, l, r - 1, dp)
        );
    }

    //LPS (Longest Palindromic Subsequence) — O(n²) - optimal
    public int minInsertions2(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        return n - lcs(s, rev);
    }
    private int lcs(String a, String b) {
        int n = a.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        MinInsertionsForPalindrome obj = new MinInsertionsForPalindrome();
        String str = "abcaa";
        System.out.println(obj.minInsertions2(str));  //2
    }
}

/*
Input: s = "abcaa"
Output: 2

Explanation: Insert 2 characters "c", and "b" to make "abcacba", which is a palindrome.
 */
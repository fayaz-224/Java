package DSA.DP;

import java.util.Arrays;

//Longest Common Subsequence
//A subsequence is a sequence that appears in the same relative order but not necessarily contiguous.
//For example, from "abcde", valid subsequences include a, ab, ace, bd etc. But "aed" is not subsequence as the characters are not in the correct order.
public class LCS {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(getLCS(text1, text2, 0, 0)); //3

        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(getLCS2(text1, text2, 0, 0, dp));
    }

    //Using Recursion
    public static int getLCS(String text1, String text2, int i, int j){
        if(i<0 || i==text1.length() || j<0 || j==text2.length())
            return 0;

        int ans;
        if(text1.charAt(i) == text2.charAt(j))
            ans =  1 + getLCS(text1,text2,i+1,j+1);
        else
            ans = Math.max(getLCS(text1,text2,i,j+1), getLCS(text1,text2,i+1,j));

        return ans;  //we can also directly return in if-else blocks instead of storing in ans.
    }

    //using Memoization
    public static int getLCS2(String text1, String text2, int i, int j, int[][] dp) {
        if (i == text1.length() || j == text2.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j]; //returns value if its already been present, no need to do repeated tasks

        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + getLCS2(text1, text2, i + 1, j + 1, dp);  //take
        } else {
            dp[i][j] = Math.max(getLCS2(text1, text2, i + 1, j, dp),
                    getLCS2(text1, text2, i, j + 1, dp));  //no take
        }

        return dp[i][j];
    }
}

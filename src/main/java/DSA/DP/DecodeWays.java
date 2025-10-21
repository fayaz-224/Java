package DSA.DP;

//https://leetcode.com/problems/decode-ways/description/
//Decode given message
public class DecodeWays {

    public static int numDecodings(String s) {  //Tabulation
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;  //If s is empty or starts with '0'. return 0 because a valid decoding is not possible.

        // dp[i] = number of ways to decode substring of length i
        int[] dp = new int[n + 1];

        // Base cases - there is only one way to decode an empty string and a string of length 1.
        dp[0] = 1;
        dp[1] = 1;

        // Fill the dp table iteratively
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));   // last 1 digit
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));  // last 2 digits

            // If the last one digit is valid (1–9), add ways from dp[i-1]
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // If the last two digits form a valid letter (10–26), add ways from dp[i-2]
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "226";
        System.out.println("Number of ways to decode \"" + s + "\": " + numDecodings(s));  //op: 3 ("226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6))
        // \" means: print a literal double quote (") instead of ending the string.
    }
}

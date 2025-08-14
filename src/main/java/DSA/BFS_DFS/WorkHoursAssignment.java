package DSA.BFS_DFS;

import java.util.*;

//You are given: A 7-character string s made of digits (0–8) or ? and A target sum T (e.g., 24).
//Replace each ? with a digit between 0 and 8.
//Count how many valid assignments make the total sum = T.
public class WorkHoursAssignment {  //backtracking with memoization (DFS + DP)

    public static int countValidAssignments(String s, int target) {
        return dfs(s.toCharArray(), 0, target, new HashMap<>());
    }

    private static int dfs(char[] s, int i, int remaining, Map<String, Integer> memo) {
        if (i == 7)
            return remaining == 0 ? 1 : 0;

        String key = i + "," + remaining;
        if (memo.containsKey(key)) return memo.get(key);

        int ways = 0;
        char ch = s[i];

        if (ch == '?') {
            for (int val = 0; val <= 8; val++) {
                if (remaining - val >= 0) {
                    ways += dfs(s, i + 1, remaining - val, memo);
                }
            }
        } else {
            int val = ch - '0';
            if (remaining - val >= 0) {
                ways = dfs(s, i + 1, remaining - val, memo);
            }
        }

        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        String s = "?23??7?";
        int T = 24;
        System.out.println("Valid combinations: " + countValidAssignments(s, T));  //op: 12 (0230077, 1230076, 0230176 etc)
    }
}

/*
public class WorkingHoursSimple {  //Using Recursion (without memoization) - O(9^n), where n = number of '?' in the string

    static int count = 0;

        public static void countWays(String s, int index, int currentSum, int target) {
            if (index == 7) {  //if we reached the end of string
                if (currentSum == target) count++;
                return;
            }

            char ch = s.charAt(index);
            if (ch == '?') {
                for (int i = 0; i <= 8; i++) {
                    countWays(s, index + 1, currentSum + i, target);
                }
            } else {
                int val = ch - '0';
                countWays(s, index + 1, currentSum + val, target);
            }
        }

    public static void main(String[] args) {
        String s = "?23??7?";
        int target = 24;

        countWays(s, 0, 0, target);
        System.out.println("Total valid ways: " + count);
    }
}
 */
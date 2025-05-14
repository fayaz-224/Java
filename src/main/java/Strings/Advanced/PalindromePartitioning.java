package Strings.Advanced;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> result = new ArrayList<>();

    private void partitionHelper(String s, int start, List<String> currentList) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end + 1));
                partitionHelper(s, end + 1, currentList);
                currentList.remove(currentList.size() - 1); // Backtrack, remove previously added element in line 18
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        String input = "aab";
        obj.partitionHelper(input, 0, new ArrayList<>());

        System.out.println("Palindrome Partitions for '" + input + "': ");
        for (List<String> partition : obj.result) {
            System.out.println(partition);
        }
    }
}

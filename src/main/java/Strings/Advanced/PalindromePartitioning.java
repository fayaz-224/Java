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

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                currentList.add(s.substring(start, i + 1));
                partitionHelper(s, i + 1, currentList);
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
        for (List<String> partition : obj.result) {  //[a, a, b], [aa, b]
            System.out.println(partition);
        }
    }
}

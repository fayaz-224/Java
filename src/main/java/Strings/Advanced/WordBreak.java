package Strings.Advanced;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Input:
dict[] = { this, th, is, famous, Word, break, b, r, e, a, k, br, bre, brea, ak, problem };
word = Wordbreakproblem

Output:
Word b r e a k problem
Word b r e ak problem
Word br e a k problem
Word br e ak problem
Word bre a k problem
Word bre ak problem
Word brea k problem
Word break problem
 */
public class WordBreak {  //backtracking

    static List<String> result = new ArrayList<>();
    public static void wordBreak(String word, Set<String> dict, int start, String current) {
        if (start == word.length()) {
            result.add(current.trim());
            return;
        }

        for (int i = start + 1; i <= word.length(); i++) {
            String substring = word.substring(start, i);
            if (dict.contains(substring)) {
                wordBreak(word, dict, i, current + substring + " ");
            }
        }
    }

    public static void main(String[] args) {
        String[] input = { "this", "th", "is", "famous", "Word", "break", "b", "r", "e", "a", "k", "br", "bre", "brea", "ak", "problem" };
        Set<String> dict = Stream.of(input).collect(Collectors.toSet());
        String word = "Wordbreakproblem";
        wordBreak(word, dict, 0, "");
        for (String b : result) {
            System.out.println(b);
        }
    }
}

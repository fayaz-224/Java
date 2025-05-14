package Strings.Advanced;

import java.util.HashMap;

//https://leetcode.com/problems/word-pattern/
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
public class WordPattern {
    public static void main(String[] args){
        String pattern = "abba", s = "dog dog dog dog";  //false
        System.out.println(findWordMatch(pattern, s));
    }

    private static boolean findWordMatch(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] str = s.split("\\s+");
        if (pattern.length() != str.length)
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(str[i]))
                    return false;
            } else if (map.containsValue(str[i]))
                return false;
            else
                map.put(pattern.charAt(i), str[i]);

        }
        return true;
    }
}


//Another way
/*
public boolean wordPattern(String pattern, String s) {
        // Map to store the relationship between pattern characters and words
        HashMap<Character, String> map = new HashMap<>();
        // Set to track words that have already been mapped
        HashSet<String> set = new HashSet<>();

        String[] input = s.split(" ");
        if (input.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!input[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                if (set.contains(input[i])) {     // If the word is already mapped to another character
                    return false;
                }

                set.add(input[i]);
                map.put(pattern.charAt(i), input[i]);
            }
        }
        return true;
    }
 */
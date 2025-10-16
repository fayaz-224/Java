package Strings.Basics;

import java.util.*;

//First non-repeating character index
//https://leetcode.com/problems/first-unique-character-in-a-string/description/
public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) { //using LinkedHashMap
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Now iterate over map in insertion order
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey()); // return first unique character's index
            }
        }

        return -1;
    }

    public static int firstUniqChar2(String s) {  //using HashMap
        if (s == null || s.isEmpty()) return -1;

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // As we are looping through original string, we don’t rely on map order.
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s)); //0
    }
}

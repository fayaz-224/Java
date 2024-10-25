package Strings;

import java.util.*;

public class StringCompression2 {

    public static String compressString(String compressed) {
        if (compressed == null || compressed.isEmpty()) return compressed;

        Map<Character, Integer> countMap = new HashMap<>();
        int i = 0;

        while (i < compressed.length()) {
            char currentChar = compressed.charAt(i);
            int numStart = ++i;  //imp

            // Move until a non-digit character (the next letter or end of string)
            while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                i++;
            }

            int count = Integer.parseInt(compressed.substring(numStart, i));
            countMap.put(currentChar, countMap.getOrDefault(currentChar, 0) + count);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            result.append(entry.getKey()).append(entry.getValue());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "a3c9b2c1";
        String output = compressString(input);
        System.out.println(output);  // Outputs: a3b2c10
    }
}

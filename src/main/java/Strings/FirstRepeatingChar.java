package Strings;

import java.util.HashSet;
import java.util.Set;

//using streams is in StreamsQue class
public class FirstRepeatingChar {
    public static char repeatingChar(String str) {
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (!set.add(ch)) {
                return ch;
            }
        }
        return '\0'; // Return null character if no repeating character found
    }

    public static void main(String[] args) {
        String str = "hello";
        char ch = repeatingChar(str);
        if (ch != '\0') {
            System.out.println("First repeating character: " + ch);
        } else {
            System.out.println("No repeating character found.");
        }
    }
}


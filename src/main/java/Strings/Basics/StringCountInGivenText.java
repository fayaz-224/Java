package Strings.Basics;

import java.util.*;

public class StringCountInGivenText { //matches non-absolute strings - partial or indirect match not necessarily in the same order("balloon" can be extracted from "ballddddoons")
    static String target = "balloon";

    static int countOfString(String text) {  //Optimized
        Map<Character, Integer> textMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        // Count frequency of characters in the target word
        for (char ch : target.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        // Count frequency of characters in the text (ignoring case)
        for (char ch : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                textMap.put(ch, textMap.getOrDefault(ch, 0) + 1);
            }
        }

        // Calculate how many times the target word can be formed
        int minCount = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            char ch = entry.getKey();
            int needed = entry.getValue();
            int available = textMap.getOrDefault(ch, 0);
            minCount = Math.min(minCount, available / needed);
        }
        return minCount;
    }

    static int countOfString2(String text) {
        char[] ch = text.toCharArray();
        int i,j,count=0;
        // we had to take infinite loop, as we need to check string until end of given text whose length is unknown.
        while(true) {
            for(i=0;i<target.length();i++) {
                for(j=0;j<ch.length;j++) {
                    if(target.charAt(i)==ch[j]) {
                        ch[j]=0;  //to avoid visited ones
                        break;
                    }
                }

                if(j==ch.length)
                    return count;
            }
            count++;
        }
    }

    public static void main(String args[]) {
        String msg = "The ballddddoons are so beautiful, red balloons are my fav";
        System.out.println(countOfString(msg));
    }
}


/*
public class StringCountInGivenText {  //matches absolute strings - Full exact match of "balloon"
    public static void main(String[] args) {
        String text = "This is a sample text to demonstrate balloon counting. This text contains sample words.";
        String searchString = "balloon";

        int count = 0;
        int index = text.indexOf(searchString);
        while (index != -1) {
            count++;
            index = text.indexOf(searchString, index + 1);
        }
        System.out.println("The given string appears " + count + " times in the text.");
    }
}
 */
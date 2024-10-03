package Collections;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsQue {
    public static void main(String[] args) {
        String str = "geeksforgeeks";

        //count the occurrence of given char [.chars() -> convert a String into an IntStream of Unicode code]
        int count = (int) str.chars()
                .filter(ch -> ch == 'e')
                .count();
        System.out.println("occurrence of given char: " + count);

        //find max occurring char
        char maxChar = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse('\0');
        System.out.println("max occurring char: "+maxChar);

        //FirstNonRepeatingChar
        Optional<Character> ch = str.toLowerCase().chars()           // IntStream
                .mapToObj(i -> (char) i)  // convert to Character object Stream
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
                .entrySet().stream()                       // EntrySet stream
                .filter(entry -> entry.getValue() == 1)   // extracts characters with a count of 1
                .map(entry -> entry.getKey())              // get the keys of EntrySet
                .findFirst();
        System.out.println("FirstNonRepeatingChar: " + ch.get());

        //firstRepeatingChar
        HashSet<Character> set = new HashSet<>();
        Character ch1 = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !set.add(c)) //The add() method returns true if the element was successfully added to the set and false if the element was already present in the set.
                .findFirst() // Find the first repeating character
                .orElse('\0');
        System.out.println("firstRepeatingChar: "+ch1);

        //count words and print only duplicates
        String strSentence = " HI EPAM bYe EPAM goodbye EPAM welcome ePAM Hi There epAM BYE bye EPaM";
        String[] words = strSentence.toLowerCase().split("\\s+");
        Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //sum of 2 arrays
        int arr1[] = {9, 8, 9};
        int arr2[] = {9, 9};
        String num1 = Arrays.stream(arr1)   // Convert arrays to strings
                .mapToObj(String::valueOf)
                .reduce("", String::concat);
        String num2 = Arrays.stream(arr2)
                .mapToObj(String::valueOf)
                .reduce("", String::concat);
        int number1 = Integer.parseInt(num1);     // Convert strings to integers
        int number2 = Integer.parseInt(num2);
        int res = number1 + number2;
        System.out.println("Sum: " + res);

        //Count the frequency of each word and print its count in descending order of frequency
        List<String> ls = Arrays.asList("apple", "banana", "orange", "apple", "kiwi", "banana", "kiwi", "kiwi");
        ls.stream()
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
            .entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Sort by value descending
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // maximum repeating string along with its count
        Map.Entry<String, Long> maxRepeating = ls.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("No elements found"));
        System.out.println("max repeating str: "+maxRepeating);

        //Palindrome check
        String str1 = "ROTATOR";
        String inputString = str1.replaceAll("\\s+", "").toLowerCase();
        boolean isItPalindrome = IntStream.range(0, inputString.length()/2)
                    .allMatch(i -> inputString.charAt(i) == inputString.charAt(inputString.length() - i -1));
            //or     .noneMatch(i -> inputString.charAt(i) != inputString.charAt(inputString.length() - i -1));
        if (isItPalindrome)
            System.out.println(inputString+" is a palindrome");
        else
            System.out.println(inputString+" is not a palindrome");
    }
}

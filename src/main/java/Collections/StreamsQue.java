package Collections;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsQue {
    public static void main(String[] args) {
        String str = "geeksforgeeks";

        //count - count the occurrence of given char [.chars() -> convert a String into an IntStream of Unicode code]
        int count = (int) str.chars().filter(ch -> ch == 'e').count();
        System.out.println("occurrence of given char: " + count);

        //FirstNonRepeatingChar
        Optional<Character> ch = str.chars()           // IntStream
                .mapToObj(i -> Character.toLowerCase((char) i))  // convert to lowercase & then to Character object Stream
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
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
    }
}

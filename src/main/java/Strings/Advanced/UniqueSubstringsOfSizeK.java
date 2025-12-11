package Strings.Advanced;

import java.util.*;

//unique contiguous substrings, not combinations (UniqueCombinationsOfSizeK).
public class UniqueSubstringsOfSizeK {  //Unique Tuples

    // Sliding window to capture substrings of length `tupleSize`
    public static Set<String> getUniqueTuples(String input, int tupleSize) {
        if (input == null || tupleSize > input.length() || tupleSize <= 0) {
            return Collections.emptySet(); // Return empty set if tupleSize is invalid
        }

        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i <= input.length() - tupleSize; i++) {
            String sub = input.substring(i, i + tupleSize);
            resultSet.add(sub);
        }
        return resultSet;
    }

    public static void main(String[] args) {
        String input = "abbccde";
        int tupleSize = 3; //k
        Set<String> uniqueTuples = getUniqueTuples(input, tupleSize);

        System.out.println("Unique tuples:" +uniqueTuples);  //[abb, bbc, bcc, ccd, cde]
    }
}
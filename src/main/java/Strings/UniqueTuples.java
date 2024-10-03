package Strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueTuples {
    public static Set<String> getUniqueTuples(String input, int tupleSize) {
        Set<String> resultSet = new HashSet<>();
        if (tupleSize > input.length() || tupleSize <= 0) {
            return resultSet; // Return empty set if tupleSize is invalid
        }

        // Sliding window to capture substrings of length `tupleSize`
        for (int i = 0; i <= input.length() - tupleSize; i++) {
            String sub = input.substring(i, i + tupleSize);
            resultSet.add(sub);
        }
        return resultSet;
    }

    public static void main(String[] args) {
        String input = "abbccde";
        int tupleSize = 2;
        Set<String> uniqueTuples = getUniqueTuples(input, tupleSize);

        System.out.println("Unique tuples:");
        uniqueTuples.forEach(t -> System.out.println("  \"" + t + "\","));
    }
}
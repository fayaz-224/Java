package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class BinaryStrings {

    static List<String> result = new ArrayList<>();
    private static void generateBinaryStrings(String prefix, int length) {
        if (prefix.length() == length) {
            result.add(prefix);
            return; // Return to avoid further recursion
        }

        // Append '0' to the prefix and continue recursion
        generateBinaryStrings(prefix + "0", length);

        // Append '1' to the prefix only if the last character is not '1'
        if (prefix.isEmpty() || prefix.charAt(prefix.length() - 1) != '1') {
            generateBinaryStrings(prefix + "1", length);
        }
    }

    public static void main(String[] args) {
        int length = 3; // Length of binary strings
        generateBinaryStrings("", length);
        System.out.println("Binary strings without consecutive 1's:");
        for (String str : result) {
            System.out.println(str);
        }
    }
}

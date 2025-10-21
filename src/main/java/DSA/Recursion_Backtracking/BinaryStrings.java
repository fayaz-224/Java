package DSA.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryStrings {

    static List<String> result = new ArrayList<>();
    private static void generateBinaryStrings(StringBuilder prefix, int length) {
        if (prefix.length() == length) {
            result.add(prefix.toString());
            return; // Return to avoid further recursion
        }

        // Append '0' to the prefix and continue recursion
        generateBinaryStrings(prefix.append('0'), length);
        prefix.deleteCharAt(prefix.length() - 1); // backtrack

        // Append '1' to the prefix only if the last character is not '1'
        if (prefix.length()==0 || prefix.charAt(prefix.length() - 1) != '1') {
            generateBinaryStrings(prefix.append('1'), length);
            prefix.deleteCharAt(prefix.length() - 1); // backtrack

        //for stringBuilder we must explicitly undo (backtrack) by removing the last character you added as it modifies the original object.
        // for String backtracking is not needed, because Java’s immutable String ensures previous states are preserved (You're not modifying the original "current" — you're creating a new string object. we don't need to UNDO(backtracking) as its original value is never changed).

        //        generateBinaryStrings(prefix + "0", length);  //append 0
        //        if (prefix.isEmpty() || prefix.charAt(prefix.length() - 1) != '1') {
        //            generateBinaryStrings(prefix + "1", length);  //append 1
        //        }
        }
    }

    public static void main(String[] args) {
        int length = 3; // Length of binary strings
        generateBinaryStrings(new StringBuilder(), length);
        System.out.println("Binary strings without consecutive 1's:");
        for (String str : result) {
            System.out.println(str);
        }
    }
}


/*
why prefix.deleteCharAt(prefix.length() - 1); ?
    After each append(...), we remove the last character before trying the next possibility.
    This allows the StringBuilder to reuse the previous state without creating a new object.
    Without this line, the StringBuilder keeps growing and you'll end up with incorrect or duplicate results.
Ex:
Start with: sb = ""
Append '0' → sb = "0"
Append '0' → sb = "00"

Append '0' → sb = "000" → ✅ Print → backtrack to "00"
sb.deleteCharAt(2) → sb = "00"

Append '1' → sb = "001" → ✅ Print → backtrack to "00"
sb.deleteCharAt(2) → sb = "00"

Backtrack to "0"
sb.deleteCharAt(1) → sb = "0"

Append '1' → sb = "01"

Append '0' → sb = "010" → ✅ Print → backtrack to "01"
sb.deleteCharAt(2) → sb = "01"

Can't append '1' (last char is '1') → skip
Backtrack to "0" → sb.deleteCharAt(1) → sb = "0"

Backtrack to "" → sb.deleteCharAt(0) → sb = ""

Append '1' → sb = "1"
Append '0' → sb = "10"
Append '0' → sb = "100" → ✅ Print → backtrack to "10"
sb.deleteCharAt(2) → sb = "10"

Append '1' → sb = "101" → ✅ Print → backtrack to "10"
sb.deleteCharAt(2) → sb = "10"

Backtrack to "1" → sb.deleteCharAt(1) → sb = "1"

Can't append '1' (last char is '1') → skip
Backtrack to "" → sb.deleteCharAt(0) → sb = ""
*/
package Strings.Basics;

public class RemoveCharFromString {
    public static String removeCharAt(String str, int index) {
        if (str == null || str.isEmpty() || index < 0 || index >= str.length()) {
            return "Invalid string or index!";
        }

        return str.substring(0, index) + str.substring(index + 1); // Concatenate the substring before and after the character to be removed
    }

    public static void main(String[] args) {
        String originalString = "example";
        int indexToRemove = 1; // Index of the character to remove

        String modifiedString = removeCharAt(originalString, indexToRemove);
        System.out.println("Original string: " + originalString);
        System.out.println("Modified string: " + modifiedString);
    }
}


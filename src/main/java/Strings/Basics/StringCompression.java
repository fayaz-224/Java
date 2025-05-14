package Strings.Basics;

public class StringCompression {
    public static String compressString(String input) {
        if(input==null || input.isEmpty())
            return "Provide valid Input";

        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {  //to avoid IndexOutOfBounds
                count++;
            } else {
                compressed.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        // Append the last character and its count
        compressed.append(input.charAt(input.length() - 1)).append(count);

        return compressed.toString();
    }

    public static void main(String[] args) {
        String input = "sssmmmnnnAAAmmmmmaaaaAAAAA";
        String compressedString = compressString(input);
        System.out.println(compressedString); // Output: s3 m3 n3 A3 m5 a4 A5
    }
}


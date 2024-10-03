package Strings;

public class RemoveSpecialChars {
    public static void main(String[] args) {
        String s = "Hi @CloudTech#@!";
        int count = 0;
        String str = "";
        //if we need to find only the count of special chars, use below code
        //remove all alphanumeric characters (\\w) and whitespace characters (\\s) from the string, result is special chars
        //int count = s.replaceAll("[\\w\\s]", "").length();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)) || Character.isWhitespace(s.charAt(i)))
                str += s.charAt(i); //string without special chars
            else
                count++;  //count of special chars
        }

        if (count == 0) {
            System.out.println("There are no special characters in the String");
        } else {
            System.out.println("Special characters found: " + count);
        }

        System.out.println(str);
    }
}

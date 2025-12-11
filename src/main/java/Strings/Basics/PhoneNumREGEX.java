package Strings.Basics;

import java.util.regex.*;

class PhoneNumREGEX {
    public static boolean isValid(String s) {
        Pattern p = Pattern.compile("^[6-9]\\d{9}$");  //\d is a regex pattern that matches a digit ([0-9]). But in Java strings, \ is an escape character, so you need to escape the backslash itself. So to represent \d in a string, you write \\d.

        Matcher m = p.matcher(s);

        return m.matches();
    }

    public static void main(String[] args) {
        String s = "7984286257";
        String s1 = "5426391";

        if (isValid(s))
            System.out.println("Valid Number");
        else
            System.out.println("Invalid Number");

        if (isValid(s1))
            System.out.println("Valid Number");
        else
            System.out.println("Invalid Number");
    }
}

/*
^ → start of string

[6-9] → first digit must be 6, 7, 8, or 9

\d{9} → followed by exactly 9 more digits

$ → end of string
*/
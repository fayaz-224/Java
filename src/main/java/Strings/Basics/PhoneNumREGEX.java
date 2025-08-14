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
^ and $: Start and end of the string.

\+91: Matches +91 literally.

[\-\s]?: Optional - or space.

[6-9]: First digit between 6 and 9 (valid for Indian numbers).

\d{9}: Next 9 digits.
*/
package Strings.Basics;

import java.util.regex.*;

class PhoneNumREGEX {
    public static boolean isValid(String s) {
        Pattern p = Pattern.compile("^\\d{10}$");
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


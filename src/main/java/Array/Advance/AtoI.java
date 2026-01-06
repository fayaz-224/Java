package Array.Advance;

//ASCII(String) to Integer
public class AtoI {
    public static int myAtoi(String str) {
        if (str == null || str.isEmpty())
            return 0;

        int index = 0;
        int result = 0;
        boolean isNegative = false;

        // skip leading white spaces
        while (index < str.length() && str.charAt(index) == ' ') {  //str = str.trim();
            index++;
        }

        // Handle the sign
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            isNegative = str.charAt(index) == '-';
            index++;
        }

        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';  // converting digit(in character form) to integer form

            // to avoid overflow in the next step (-digit, /10 are becoz we do opposite of these calculations in next step. This prevents overflow before it happens.)
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            // adding digits at their desired place-value
            result = result * 10 + digit;

            index++;
        }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        String s1 = "42";
        String s2 = "   -123abc";
        String s3 = "-196  ";
        String s4 = "26478726384783";

        System.out.println(myAtoi(s1));  // Output: 42
        System.out.println(myAtoi(s2));  // Output: -123 breaks if non digit is found
        System.out.println(myAtoi(s3));  // Output: -196
        System.out.println(myAtoi(s4));  // Output: The converted number is greater than 2^31 – 1, therefore print 2^31 – 1 = 2147483647 (MAX_VALUE).
    }
}

package Strings.Basics;

// Returns the largest odd number substring from the given string
class LargestOddNum {

    //The largest number comes from the longest prefix ending at an odd digit.
    public static String largeOddNum(String s) {
        int lastOddIndex  = -1;

        // Find the last odd digit in the string
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) % 2 != 0) {  //if ((s.charAt(i) - '0') % 2 == 1) for good intent
                lastOddIndex  = i;
                break;
            }
        }

        // Return empty string if no odd digit was found
        if (lastOddIndex  == -1) return "";

        // Skip leading zeroes up to the odd digit
        i = 0;
        while (i <= lastOddIndex  && s.charAt(i) == '0') i++;

        // Return substring from first non-zero to odd digit
        return s.substring(i, lastOddIndex  + 1);
    }

    public static void main(String[] args) {
        String num = "504";
        String result = largeOddNum(num);
        System.out.println("Largest odd number: " + result);
    }
}

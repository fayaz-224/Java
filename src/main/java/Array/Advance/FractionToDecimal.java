package Array.Advance;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fraction-to-recurring-decimal/description/
public class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        // Handle edge case where numerator & denominator is 0
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        if (numerator == 0) {
            return "0";
        }

        // Determine the sign of the result - using XOR as we might get both -ve values
        StringBuilder result = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Work with absolute values to simplify
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        // Append the integer part
        result.append(num / denom);
        long remainder = num % denom;

        // If no remainder, return the integer part
        if (remainder == 0) {
            return result.toString();
        }

        // Append decimal point
        result.append(".");

        // Use a map to store the position of each remainder
        Map<Long, Integer> remainderMap = new HashMap<>();
        remainderMap.put(remainder, result.length());  //map(reminder, index)

        // Compute the fractional part
        while (remainder != 0) {
            remainder *= 10;
            result.append(remainder / denom);
            remainder %= denom;

            if (remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                String nonRepeatingPart = result.substring(0, index);
                String repeatingPart = result.substring(index);
                return nonRepeatingPart + "(" + repeatingPart + ")";
            }

            remainderMap.put(remainder, result.length());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 3)); // Output: "0.(3)"
        System.out.println(fractionToDecimal(2, 7)); // Output: "0.(285714)"
        System.out.println(fractionToDecimal(-1, -2)); // Output: "0.5"
        System.out.println(fractionToDecimal(1, -6)); // Output: "-0.1(6)"
        System.out.println(fractionToDecimal(0, 1)); // Output: "0"
    }
}

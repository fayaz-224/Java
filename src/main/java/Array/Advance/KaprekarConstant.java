package Array.Advance;

import java.util.Arrays;

//take a four-digit number, arrange its digits in descending and ascending order to create two new numbers, and then subtract the smaller number from the larger one.
// Repeating this process will eventually lead to Kaprekar's Constant, 6174.
//3-digit Kaprekar constant is 495.
public class KaprekarConstant {

    public static final int KAPREKAR_CONSTANT = 6174;

    public static int kaprekarSteps(int num) {
        int steps = 0; //count
        while (num != KAPREKAR_CONSTANT) {
            int[] digits = new int[4];
            for (int i=0; i<4; i++) {  // Get digits from number
                digits[i] = num % 10;
                num /= 10;
            }
            Arrays.sort(digits);
            int asc = ascending(digits);
            int desc = descending(digits);
            num = Math.abs(asc - desc);
            steps++;

            //or
            //String s = String.valueOf(num).trim();
            //char[] digits = s.toCharArray();
            //Arrays.sort(digits);
            //int asc = Integer.parseInt(new String(digits));
            //int desc = Integer.parseInt(new StringBuilder(new String(digits)).reverse().toString());
            //num = desc - asc;
            //count++;

            if (num == 0) break;  // all digits same
        }
        return steps;
    }

    private static int ascending(int[] digits) {
        int asc = 0;
        for (int i=0; i<4; i++)
            asc = asc*10 + digits[i];
        return asc;
    }

    private static int descending(int[] digits) {
        int desc = 0;
        for (int i=3; i>=0; i--)
            desc = desc*10 + digits[i];
        return desc;
    }

    public static void main(String[] args) {
        int number = 3524;
        System.out.println("No. of steps to reach Kaprekar's Constant from " + number + ": " + kaprekarSteps(number));
    }
}

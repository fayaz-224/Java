package Array.Basics;
import java.util.Scanner;

public class NumberToWords {

    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String convertToWords(int number) {
        if (number == 0) {
            return "Zero";
        }
        if (number < 0 || number > 9999) {
            return "Number out of range";
        }

        // Extract digits
        int onesPart = number % 10;
        int tensPart = (number / 10) % 10;
        int hundreds = (number / 100) % 10;
        int thousands = number / 1000;
        System.out.println("Given digits are "+thousands+" "+hundreds+" "+tensPart+" "+onesPart);

        StringBuilder result = new StringBuilder();

        if (thousands > 0) {
            result.append(units[thousands]).append(" Thousand ");
        }
        if (hundreds > 0) {
            result.append(units[hundreds]).append(" Hundred ");
        }
        if (tensPart == 1 && onesPart > 0) {
            result.append(teens[onesPart] + " ");
        } else {
            if (tensPart > 0)
                result.append(tens[tensPart] + " ");
            if (onesPart > 0)
                result.append(units[onesPart] + " ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter the number");
    	int number = scan.nextInt();
        String words = convertToWords(number);
        System.out.println(number + " in words: " + words);
        scan.close();
    }
}


/*
public class NumberToWords {
    public static void main(String[] args) {

        int number = 119;
        if (number < 0 || number > 999) {
            System.out.println("Invalid Number");
        } else {
            int onesPart = number % 10;
            int tensPart = (number / 10) % 10;
            int hundredsPart = (number / 100) % 10;

            String sD[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
            String ty[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

            if (number == 0) {
                System.out.println("Zero");
            } else if (number < 20) {
                System.out.println(sD[number]);
            } else if (number < 100) {
                System.out.println(ty[tensPart] + " " + sD[onesPart]);
            } else if (number < 1000) {
                if (number % 100 < 20) {
                    System.out.println(sD[hundredsPart] + " Hundred " + sD[number % 100]);
                } else {
                    System.out.println(sD[hundredsPart] + " Hundred " + ty[tensPart] + " " + sD[onesPart]);
                }
            } else {
                System.out.println("Provide a number below 1000");
            }
        }
    }
}
*/
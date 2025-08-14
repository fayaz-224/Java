package Array.Basics;

public class NumberToWords {

    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String convertToWords(int number) {
        if (number == 0) return "Zero";
        if (number < 0 || number > 9999) return "Number out of range";

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
            result.append(teens[onesPart]).append(" ");
        } else {
            if (tensPart > 0)
                result.append(tens[tensPart]).append(" ");
            if (onesPart > 0)
                result.append(units[onesPart]).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
    	int number = 119;
        String words = convertToWords(number);
        System.out.println(number + " in words: " + words);
    }
}


/*
public class NumberToWords {

    private static final String[] units = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };
    private static final String[] teens = {
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static String convertToWords(int number) {
        if (number == 0) return "Zero";
        if (number < 0 || number > 9999) return "Number out of range";

        StringBuilder result = new StringBuilder();

        if (number >= 1000) {
            result.append(units[number / 1000]).append(" Thousand ");
            number %= 1000;
        }
        if (number >= 100) {
            result.append(units[number / 100]).append(" Hundred ");
            number %= 100;
        }
        if (number >= 20) {
            result.append(tens[number / 10]).append(" ");
            number %= 10;
        } else if (number >= 10) {
            result.append(teens[number - 10]).append(" ");
            number = 0;
        }
        if (number > 0) {
            result.append(units[number]).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = scan.nextInt();
        System.out.println(number + " in words: " + convertToWords(number));
        scan.close();
    }
}
*/
package Array.Basics;

//find sum of digits of a number until sum becomes single digit.
public class IntSumToSingleDigit {
    public static void main(String[] args) {  //TC: O(log n)
        int num = 1234;
        while (num >= 10) {
            num = sumOfIndividualDigits(num);
        }
        System.out.println("Sum of digits until single digit: " + num);
    }

    public static int sumOfIndividualDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

/*
//use a math trick (digital root): All numbers can be reduced to a single digit using modulo 9.
//Works for any positive integer.
public class IntSumToSingleDigit {
    public static void main(String[] args) {
        int num = 1234;
        System.out.println("Sum of digits until single digit: " + digitalRoot(num));
    }

    public static int digitalRoot(int num) {
        if (num == 0) return 0;
        return 1 + (num - 1) % 9;
    }
}

//digitalRoot = 1 + (1234 - 1) % 9
//        = 1 + (1233 % 9)
//        = 1 + 0
//        = 1
*/
package Basics;

//find sum of
// digits of a number until
// sum becomes single digit.

public class IntSumToSingleDigit {

    static int digSum(int n) {
        int sum = 0;
        while (n > 0 || sum > 9) {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            int k = n % 10;
            sum += k;
            n /= 10;
        }
        return sum;
    }

    public static void main(String argc[]) {
        int n = 1234;
        System.out.println(digSum(n));
    }
}
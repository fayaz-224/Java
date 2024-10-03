package Array.Basics;

//find sum of digits of a number until sum becomes single digit.
public class IntSumToSingleDigit {
    public static void main(String[] args) {
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
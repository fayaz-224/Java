package Array.Basics;

public class FactorialAndTrailingZeroes {

    //A simple method is to first calculate factorial of n, then count trailing 0s in the result but this can cause overflow for bigger numbers.
    static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    static int countTrailingZeroes(long factorialResult) { //Approach-1
        int count = 0;
        while (factorialResult % 10 == 0) {
            count++;
            factorialResult /= 10;
        }
        return count;
    }

    // The idea is to consider prime factors of a factorial n. A trailing zero is always produced by prime factors 2 and 5.
    static int countTrailingZeroes(int n) {  //Approach-2
        if (n < 0) // -ve number Edge Case
            return -1;

        int count = 0;
        // Count the number of factors of 5 in the factorial of n: Trailing 0s in n! = Count of 5s in prime factors of n!
        for (int i = 5; n / i >= 1; i *= 5) {  // Keep dividing n by powers of 5 and update count
            count += n / i;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        long fact = factorial(n);
        System.out.println("Factorial of " + n + ": " + fact);
        System.out.println("Number of trailing zeroes: " + countTrailingZeroes(fact));  //passing factorial result

        System.out.println("Number of trailing zeroes: " + countTrailingZeroes(n));  //passing num directly
    }
}


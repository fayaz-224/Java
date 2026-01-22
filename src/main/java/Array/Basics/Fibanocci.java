package Array.Basics;

//It's a series of numbers in which, each number is the sum of the two preceding numbers
public class Fibanocci {

    static void fib1(int n) { //Iterative - Optimal
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    public static int nthFibNumber(int n) { //recursion - not optimal
        if (n <= 1)
            return n;
        return nthFibNumber(n - 1) + nthFibNumber(n - 2);
    }

    public static void main(String[] args) {
		int n=5;
        System.out.println(n + "th fibonacci no. is : " + nthFibNumber(n));

        System.out.println("Fib series up to n:");
        for (int i = 0; i <= n; i++)    //i<=n becoz we need upto n as zero is also needed
            System.out.print(nthFibNumber(i)+" ");

        System.out.println("\nFib series of n:");
        fib1(n);
    }
 }

 /*
import java.util.Arrays;

public class FibonacciDP {   //DP

    static int fib(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        for (int i = 0; i < n; i++) {
            System.out.print(fib(i, memo) + " ");
        }
    }
}
*/
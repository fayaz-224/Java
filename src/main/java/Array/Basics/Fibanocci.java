package Array.Basics;

//It's a series of numbers in which, each number is the sum of the two preceding numbers

public class Fibanocci {  //nth fibonacci no. using recursion

    public static int nthFibNumber(int n) {
        if (n <= 1)
            return n;
        return nthFibNumber(n - 1) + nthFibNumber(n - 2);
    }

    public static void main(String[] args) {
		int n=5;
        System.out.println(n + "th fibonacci no. is : " + nthFibNumber(n));

        System.out.println("Fib series upto n:");
        for (int i = 0; i <= n; i++)    //i<=n becoz we need upto n as zero is also needed
            System.out.print(nthFibNumber(i)+" ");
    }
 }

 /*
import java.util.Arrays;

public class FibonacciDP {   //DP

    static int fibonacciDP(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; ++i) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacciDP(5));
    }
}
  */


/*
class Fibonacci {	//Fibonacci series up to a given number
public static void main(String[] args) {
   if (n <= 1) return n;

  int n = 100, firstTerm = 0, secondTerm = 1;
  System.out.println("Fibonacci Series Upto " + n + ": ");

  while (secondTerm <= n) {
    System.out.print(firstTerm + ", ");

    int nextTerm = firstTerm + secondTerm;
    firstTerm = secondTerm;
    secondTerm = nextTerm;
   }
 }
}
 */
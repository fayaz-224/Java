package Basics;
import java.util.Scanner;

//a series of numbers in which, each number is the sum of the two preceding numbers
/*
class Fibanocci  //total n fibonacci numbers
{  	
	public static void main(String args[])  
	{    
		int a=0,b=1,c,n; 
		Scanner S=new Scanner(System.in);
		n=S.nextInt(); //n represents how many fib numbers u want to display
		    
		for(int i=1;i<=n;i++)	
		{    
			System.out.print(a+" ");  
			c=a+b;    
			a=b;    
			b=c;  
		}
		 S.close();
	}
}
*/

//nth fibonacci no. using recurssion
public class Fibanocci {
    static int n1 = 0, n2 = 1, n3;

    public static int nthFibNumber(int n) {
        if (n <= 1)
            return n;
        return nthFibNumber(n - 1) + nthFibNumber(n - 2);
    }

    public static void main(String[] args) 
    {
        System.out.println("Enter the value of n : ");
        Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

        System.out.println(n + "th fibonacci no. is : " + nthFibNumber(n));
        System.out.println("Fib series upto n:");
        for (int i = 0; i <= n; i++)    //i<=n becoz we need upto n as zero is also needed
            System.out.println(nthFibNumber(i));
    }
 }

 /*
 class Fibonacci {	//Fibonacci series up to a given number
 public static void main(String[] args) {

   int n = 100, firstTerm = 0, secondTerm = 1;
       
   System.out.println("Fibonacci Series Upto " + n + ": ");
   
   while (firstTerm <= n) {
     System.out.print(firstTerm + ", ");

     int nextTerm = firstTerm + secondTerm;
     firstTerm = secondTerm;
     secondTerm = nextTerm;

   }
 }
}
 */
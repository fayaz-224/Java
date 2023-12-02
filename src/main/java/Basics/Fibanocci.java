package Basics;
import java.util.Scanner;

// fibonacci no's of n times. 

import java.util.Scanner;
/*
class Fibanocci  //fibonacci series upto n terms
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
 public class Fibanocci  //a series of numbers in which, each number is the sum of the two preceding numbers
{
	 public static int fib(int n)
	    {
	        if(n==1)  
	            return 0;
	        if(n==2)
	            return 1;
	        
	        return fib(n-1)+fib(n-2);
	         
	    }
    public static void main(String[] args) 
    {
        System.out.println("Enter the value of n : ");
        
        Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        System.out.println("\n"+n+"th value in fibonacci series is : "+ fib(n));
         
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
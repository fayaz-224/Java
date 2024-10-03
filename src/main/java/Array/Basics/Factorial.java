package Array.Basics;

/*
public class Factorial{
	public static void main(String args[]) {
	int n=5, fact=1;
	 
    for(int i=n;i>=1;i--) {   //for(int i=1;i<=n;i++)
        fact=fact*i;
    }
	System.out.println("factorial is "+fact);
	}
}
*/

class Factorial { //the product of all the positive numbers less than or equal to a number
   
    static int factorial(int n) {
        if (n <= 1)
            return 1;
        return  n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int num = 3;
        System.out.println("Fact of " +num + " is " + factorial(num));
    }
}

package Array.Basics;

/*
public class Factorial{
	public static void main(String args[]) {
	int n=5, fact=1;
	 
    for(int i=n;i>=2;i--) {   //or for(int i=2;i<=n;i++) - we are only going till 2 because multiplying with 1 doesn't change anything.
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

package Array.Basics;

//the product of all the positive numbers less than or equal to a number
public class Factorial{
	public static void main(String args[]) {
	int n=5, fact=1;

    while (n > 0) {
        fact *= n;
        n--;
    }

//    for(int i=n;i>=1;i--) {   //or for(int i=1;i<=n;i++)
//        fact = fact*i;
//    }

	System.out.println("factorial is "+fact);
	}
}

/*
class Factorial {
   
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
*/
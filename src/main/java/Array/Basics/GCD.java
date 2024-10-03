package Array.Basics;

//Least Common Multiple (LCM) of two or more numbers is the least positive number that can be divided by both the numbers, without leaving the remainder.
//gcd(a,b) = a*b/lcm(a,b);
//lcm(a,b) = a*b/gcd(a,b);
/*
public class GCD {
    public static void main(String[] args) {
    	
        int num1 = 55, num2 = 121, gcd = 1, lcm=1;
        for(int i = 1; i <= num1 && i <= num2; i++) {   //GCD
            if(num1%i==0 && num2%i==0)
                gcd = i;
        }
        lcm=(num1*num2)/gcd;  //LCM
        
        System.out.printf("GCD of %d and %d is: %d\n", num1, num2, gcd);
        System.out.printf("LCM of %d and %d is: %d", num1, num2, lcm);
    }
}
*/

//It is the highest common number that completely divides given numbers. It is also known as the Greatest Common Factor (GCF) and the Highest Common Factor (HCF).
 class GCD {
    static int gcd(int a, int b) {
      if (b == 0)
        return a;
      return gcd(b, a % b);	 // replacing a with b and b with modulus(a,b) as long as b != 0
    }
     
    public static void main(String[] args) {
        int a = 93, b = 9;
        System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b));
    }
}

package Array.Basics;

//without using 3rd variable
 public class Swap {
    public static void main(String[] args) {
        int a=5,b=3;    
        System.out.println("before swapping: " + a + " " + b);
        //approach-1
        a = a + b;
        b = a-b;   
        a = a-b;
        System.out.println("after 1st swapping: " + a + " " + b);

        //approach-2
        //Xor of a same number is always Zero: 5 ^ 5 = 0
        a = a ^ b;
        b = a ^ b;  //b = (a = a ^ b) ^ b  => b = a
        a = a ^ b;  //a = (a = a ^ b) ^ (b = a)  => a = b
        System.out.println("after 2nd swapping: " + a + " " + b);
    }    
} 


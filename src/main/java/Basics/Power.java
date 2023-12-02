package Basics;
//import java.lang.Math;
  
class Power { 
  
    public static void main(String args[]) 
    { 
       int a = 3; 
       int b = 2; 
       System.out.println(Math.pow(a, b)); //output of power will be a double always
  
        a = 3; 
        b = 4; 
        double d= Math.pow(a,b);
        int c=(int)d;	//type casted
        System.out.println(c);
  
        a = 2; 
        b = 6; 
        System.out.println((int)Math.pow(a, b)); 
    } 
} 
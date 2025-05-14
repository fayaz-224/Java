package Strings.Basics;

// swapping 2 strings without using 3rd string
public class Swap {
    public static void main(String[] args) {
        String str1 = "Gd", str2 = "mrng";    
        System.out.println("Strings before swapping: " + str1 + " " + str2);
           
        str1 = str1 + str2;    
         
        str2 = str1.substring(0, str1.length() - str2.length());
        
        str1 = str1.substring(str2.length());    
            
        System.out.println("Strings after swapping: " + str1 + " " + str2);
    }    
} 



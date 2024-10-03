package Strings;

import java.util.Scanner;

//two strings are anagrams if they contain the same characters but in a different order.
public class Anagram {
//    public static boolean checkAnagram(String s1, String s2)
//    {        
//        s1 = s1.replaceAll("\\s", ""); // Remove all the white space
//        s2 = s2.replaceAll("\\s", "");
//      
//        if(s1.length() != s2.length())
//            return false;
//        else {
//            char[] arr1 = s1.toLowerCase().toCharArray();
//            char[] arr2 = s2.toLowerCase().toCharArray();
//            
//           Arrays.sort(arr1); // Sort both Character Array
//           Arrays.sort(arr2);
//           for (int i = 0; i < arr1.length; i++)
//               if (arr1[i] != arr2[i])
//                   return false;
//    
//           return true;
//           //--or-- return (Arrays.equals(arr1, arr2));
//        }
//    }
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the First String : ");
        String s1 = scanner.nextLine();         
        System.out.print("Enter the second String : ");
        String s2 = scanner.nextLine();
        
        if(checkAnagram(s1, s2))
            System.out.println(s1+" and "+s2+" are Anagrams");
        else
            System.out.println(s1+" and "+s2+" are NOT Anagrams");
        
    }       

// without using Arrays functions
 
// Bitwise XOR returns 1 if the digits are different and 0 if the digits are same.
// After all the XOR�ing process, if the result is 0 then the strings are anagrams.

    public static boolean checkAnagram(String s1, String s2) {
        s1 = s1.replaceAll("\\s", "");// Remove all the white space
        s2 = s2.replaceAll("\\s", "");
      
        if(s1.length() != s2.length())
            return false;
        else {
        	char[] arr1 = s1.toLowerCase().toCharArray();
        	char[] arr2 = s2.toLowerCase().toCharArray();
        	int xor = 0;
        	for (int i = 0; i < arr1.length; i++) {
        		xor ^= arr1[i] ^ arr2[i];
        	}
            return xor == 0; //return type is boolean
        }
    }
}

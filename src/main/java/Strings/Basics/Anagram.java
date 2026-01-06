package Strings.Basics;

import java.util.Arrays;

//two strings are anagrams if they contain the same characters but in a different order.
public class Anagram {
	
    public static void main(String[] args) {
        String s1 = "shaik";
        String s2 = "fayaz";
        
        if(checkAnagram(s1, s2))
            System.out.println(s1+" and "+s2+" are Anagrams");
        else
            System.out.println(s1+" and "+s2+" are NOT Anagrams");
    }       

    // without using Arrays functions
    // After all the XORing process, if the result is 0 then the strings are anagrams, if result is 1 they are not anagrams.
    public static boolean checkAnagram(String s1, String s2) {
        s1 = s1.replaceAll("\\s", "");
        s2 = s2.replaceAll("\\s", "");
      
        if(s1.length() != s2.length())
            return false;

        char[] arr1 = s1.toLowerCase().toCharArray();
        char[] arr2 = s2.toLowerCase().toCharArray();
        int xor = 0;
        for (int i = 0; i < arr1.length; i++) {
            xor ^= arr1[i] ^ arr2[i];
        }
        return xor == 0; //return type is boolean
    }

    public boolean CheckAnagram2(String str1, String str2) {   //Approach - 2
        if (str1.length() != str2.length())
            return false;

        // Initialize a frequency array to store character counts
        int[] freq = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'A']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            freq[str2.charAt(i) - 'A']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)  // If any frequency is non-zero, they are not anagrams
                return false;
        }

        return true;
    }

    //Using Array functions
    public static boolean checkAnagram3(String s1, String s2) {
        s1 = s1.replaceAll("\\s", "");
        s2 = s2.replaceAll("\\s", "");

        if(s1.length() != s2.length())
            return false;

        char[] arr1 = s1.toLowerCase().toCharArray();
        char[] arr2 = s2.toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
        //or use return (Arrays.equals(arr1, arr2)); instead of for loop
    }
}

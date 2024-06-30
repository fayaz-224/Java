package Strings;

import java.util.*;

// without using string functions
class UpperCase {  //A=65 to Z=90; a=97 to z=122
     public static void main(String args[]) {
         System.out.println("Enter any string which is to be converted to upper case");
         Scanner sc = new Scanner(System.in);
         String st=sc.nextLine();

         char[] str = st.toCharArray();
         for(int i=0;i<str.length;i++) {
             if(str[i]>='a' && str[i]<='z') {
                 str[i]=(char)(str[i]-32);  //for uppercase case
                 // str[i]=(char)(str[i]+32);  //for lower case
             }
         }

         System.out.println("The string in UpperCase is");
         for(int i=0;i<str.length;i++)
             System.out.print(str[i]);
     }
}

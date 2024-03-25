package Strings;

// without using string functions
import java.util.*;
class UpperCase
{
 public static void main(String args[])
 {
     System.out.println("Enter any string which is to be converted to upper case");
     Scanner sc = new Scanner(System.in); 
     String st=sc.nextLine();
     
     char[] str = st.toCharArray();
     for(int i=0;i<str.length;i++)
     {
         if(str[i]>='a' && str[i]<='z') //A=65 to Z=90; a=97 to z=122
         { 
        	 str[i]=(char)(str[i]-32);  //+32 for lower case
         }
     }

     System.out.println("The string in UpperCase is");
     for(int i=0;i<str.length;i++)
    	 System.out.print(str[i]);
 }
}

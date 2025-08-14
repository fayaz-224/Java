package Strings.Basics;

// without using string functions
class UpperCase {  //A=65 to Z=90; a=97 to z=122
     public static void main(String args[]) {
         String st = "welcome";

         char[] ch = st.toCharArray();
         for(int i=0;i<ch.length;i++) {
             if(ch[i]>='a' && ch[i]<='z') {
                 //Difference between corresponding lowercase and uppercase letters is 32
                 ch[i]=(char)(ch[i]-32);  //for uppercase case
                 // ch[i]=(char)(ch[i]+32);  //for lower case
             }
         }

         System.out.println("The string in UpperCase is");
         for(int i=0;i<ch.length;i++)
             System.out.print(ch[i]);
     }
}

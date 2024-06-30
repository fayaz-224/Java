package Strings;
/*
class StringFormatter {
	public static String reverseWord(String str){  
    String words[]=str.split("\\s+");  
    String reverseWord="";  
    for(String w:words){  
        StringBuilder sb=new StringBuilder(w);  
        sb.reverse();  
        reverseWord += sb.toString()+" ";  
    }  
    return reverseWord.trim();  
   }
}  
public class ReverseEachWord {  
public static void main(String[] args) {  
    System.out.println(StringFormatter.reverseWord("my name is khan"));  
    System.out.println(StringFormatter.reverseWord("I am sonoo jaiswal"));    
    }  
}  
*/


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseEachWord {
    static void reverseEachWordOfString(String inputString) {
        String[] words = inputString.split("\\s+"); // + means continuous spaces
         //using Streams
        List<String> res = Arrays.stream(words).map(word -> new StringBuilder(word).reverse().toString()).collect(Collectors.toList());
        System.out.println("Stream op: "+res);

        //without streams
        String reverseString = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];  //take words one by one.
             
            String reverseWord = "";
            for (int j = word.length()-1; j >= 0; j--) {   //reverse them
                reverseWord += word.charAt(j);
            }
             
            reverseString += reverseWord + " ";
        }
         
        System.out.println(inputString);
        System.out.println(reverseString.trim()); //strip() can also be used
         
        System.out.println("-------------------------");
    }
     
    public static void main(String[] args) {
        reverseEachWordOfString("Java Concept Of The Day");
        reverseEachWordOfString("Java J2EE JSP Servlets Hibernate Struts");
        reverseEachWordOfString("I am string not reversed");
        reverseEachWordOfString("Reverse Me");
    }
}
 

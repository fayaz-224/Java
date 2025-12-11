package Strings.Basics;

//counting no. of words in a string
public class WordCount {
	public static void main(String args[]) {
		String s = "welcome to the java tutorial.";
 
		//String s1[]=s.trim().split("\\s+");	 	// "\\s" works if there is only one space after the words.So use \\s+
		//System.out.println(s1.length);
		 
		int count = 1;  //count of spaces which gives no. of words (count+1) - Its '1' as there will be an extra word compared to spaces
		for (int i = 0; i < s.length()-1; i++) {
			if ((s.charAt(i) == ' ') && (s.charAt(i + 1) != ' '))
				count++;
		}
 		System.out.println("Number of words in a string = " + count);
	}
}
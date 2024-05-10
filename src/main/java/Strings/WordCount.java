package Strings;

//counting no. of words in a string
public class WordCount {
	public static void main(String args[]) {
		String s = "welcome to the java tutorial.";
 
		//String s1[]=s.split("\\s+");	 	// \\s works if there is only one space after the words.So use \\s+
		//System.out.println(s1.length);
		 
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == ' ') && (s.charAt(i + 1) != ' '))
				count++; //counting spaces, so start count from 1
		}
 		System.out.println("Number of words in a string = " + count);
	}
}
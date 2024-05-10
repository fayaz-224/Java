package Basics;

import java.util.Scanner;

//counting vowels in  a string
class Vowels {
	public static void main(String[] args) {
		int count=0;
		System.out.println("enter the String");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String s1 = s.toLowerCase(); //to get o/p as it is.
		
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)=='a'||s1.charAt(i)=='e'||s1.charAt(i)=='i'||s1.charAt(i)=='o'||s1.charAt(i)=='u') {
				count++;
				System.out.print(s.charAt(i)+" "); //prints vowel as it is given in i/p.
			}
		}
		System.out.print("\n"+count); //prints count of vowels 
	}

}
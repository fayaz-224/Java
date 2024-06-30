package Strings;

import java.util.Scanner;

// check given string is a palindrome or not
//String should be same in any direction
public class Palindrome {
	public boolean isPalindrome(String str) {
		//strings are immutable. so convert it into string buffer or builder
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String rev = sb.toString();  //Again convert it into string
        return str.equals(rev);
	}

	//Approach2
	static boolean isPalindrome2(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();

		Palindrome p = new Palindrome();
		if (p.isPalindrome2(str, 0, str.length()-1))
			System.out.println("Palindrome");
		else
			System.out.println("not a Palindrome");
	}  
} 


/*

public class Palindrome{
public static void main(String args[]){
    String a, b = "";
    Scanner s = new Scanner(System.in);
    System.out.print("Enter the string you want to check:");
    a = s.nextLine();
    int n = a.length();
    for(int i = n-1; i >= 0; i--)	//--or-- we can use swapping technique using while(s<e){swap s and e};
    {
        b = b + a.charAt(i);
    }
    if(a.equalsIgnoreCase(b))
        System.out.println("The string is palindrome.");
    else
        System.out.println("The string is not palindrome.");
}
}   


*/
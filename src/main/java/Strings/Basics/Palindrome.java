package Strings.Basics;

// check given string is a palindrome or not - String should be same in any direction
public class Palindrome {

	public boolean isPalindrome(String str) {
		//strings are immutable. so convert it into string buffer or builder
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String rev = sb.toString();  //Again convert it into string
        return str.equals(rev);
	}

	//Approach2
	static boolean isPalindrome2(String s) {
		int start = 0, end = s.length()-1;
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "mom";

		Palindrome p = new Palindrome();
		if (p.isPalindrome2(str))
			System.out.println("Palindrome");
		else
			System.out.println("not a Palindrome");
	}  
}
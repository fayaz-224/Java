// check given string is a palindrome or not
//String should be same in any direction
package Strings;
import java.util.Scanner;

public class Palindrome {
	public boolean isPalindrome(String str) {
		//strings are immutable. so convert it into string buffer or builder
		StringBuffer sb=new StringBuffer(str);
		sb.reverse();
		String rev = sb.toString();  //Again convert it into string
        return str.equals(rev);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();    //strings are immutable. so convert it into string buffer or builder

		Palindrome p = new Palindrome();
		if (p.isPalindrome(str)) {
			System.out.println("Palindrome");
		}
		else{  
			System.out.println("not a Palindrome"); 
		}  
	}  
} 


/*

public class Palindrome
{
public static void main(String args[])
{
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
package Array.Basics;
import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {

		System.out.println("enter year");
		Scanner S = new Scanner(System.in);
		int year = S.nextInt();
		 
		 if((year%4==0 && year%100!=0) || (year%400==0)) {
		       System.out.println("LEAP YEAR");
		 } else {
		       System.out.println("NORMAL YEAR");
		 }
	}
} 
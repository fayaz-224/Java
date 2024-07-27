package Basics;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Date {
	public static void main(String[] args) {
		java.util.Date d = new java.util.Date(); //gives current system date
		System.out.println(d); //Wed May 08 09:14:54 IST 2024

		SimpleDateFormat f = new SimpleDateFormat("E yyyy:mm:dd 'at' hh:mm:ss a zzz"); //based on our requirement
		System.out.println(f.format(d));

		LocalDate l = LocalDate.now();
		System.out.println(l); //2024-05-08
	}
}

package Array.Basics;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		Date d = new Date(); //gives current system date - old package
		System.out.println(d);

		SimpleDateFormat f = new SimpleDateFormat("E yyyy:mm:dd 'at' hh:mm:ss a zzz"); //based on our requirement
		System.out.println(f.format(d));

		LocalDate l = LocalDate.now();
		System.out.println(l); //2024-05-08
	}
}

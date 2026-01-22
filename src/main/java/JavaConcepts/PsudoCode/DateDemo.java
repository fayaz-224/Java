package JavaConcepts.PsudoCode;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		//old package (java.util)
		Date d = new Date();
		System.out.println(d);  //OP: Sun Jul 27 00:07:43 IST 2025

		SimpleDateFormat f = new SimpleDateFormat("E yyyy:mm:dd 'at' hh:mm:ss a zzz"); //based on our requirement
		System.out.println(f.format(d));

		//modern package (java.time)
		LocalDate l = LocalDate.now();
		System.out.println(l); //2025-07-27
	}
}

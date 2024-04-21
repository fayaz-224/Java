package Basics;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo 
{
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);// gives current system date

		SimpleDateFormat f = new SimpleDateFormat("E yyyy:mm:dd 'at' hh:mm:ss a zzz"); //based on our requirement
		System.out.println(f.format(d));
	}
}

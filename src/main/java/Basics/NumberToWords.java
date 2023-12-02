package Basics;
import java.util.Scanner;

public class NumberToWords {

    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String convertToWords(int number) {
        if (number == 0) {
            return "Zero";
        }
        if (number < 0 || number > 9999) {
            return "Number out of range";
        }

        // Extract digits
        int thousands = number / 1000;
        int hundreds = (number % 1000) / 100;
        int tensPart = (number % 100) / 10;
        int onesPart = number % 10;
        System.out.println(thousands+" "+hundreds+" "+tensPart+" "+onesPart);

        StringBuilder result = new StringBuilder();

        if (thousands > 0) {
            result.append(units[thousands]).append(" Thousand ");
        }

        if (hundreds > 0) {
            result.append(units[hundreds]).append(" Hundred ");
        }

        if (tensPart == 1 && onesPart > 0) {
            result.append(teens[onesPart]);
        } else {
            if (tensPart > 0) {
                result.append(tens[tensPart]);
            }
            if (onesPart > 0) {
                result.append(units[onesPart]);
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter the number");
    	int number = scan.nextInt();
        String words = convertToWords(number);
        System.out.println(number + " in words: " + words);
        scan.close();
    }
}


/*
public class NumberToWords { //not working properly for 119 etc

 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter the number");
  int number = scan.nextInt();
  
  if(number < 1|| number > 9999) {
   System.out.println("Invalid Number");
  }else {
   int a = number%10; //last digit
   int b = number/10;
   int c = b%10;
   int g = number/100;
   int d = g%10;
   int e = number/1000;
   String sD[] = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Ninteen"};
   String ty[] = {"","Ten","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
   String h = "Hundred";
   String th = "Thousand";
   if(number < 20)
	   System.out.println(sD[number]);
   else if (number >= 20 && number <= 100)
	   System.out.println(ty[c]+" "+sD[a]);
   else if(number >= 100 && number <= 999)
	   System.out.println(sD[g]+" "+h+" "+ty[c]+" "+sD[a]);
   else
	   System.out.println(sD[e]+" "+th+" "+sD[d]+" "+h+" "+ty[c]+" "+sD[a]);
    
  }
  scan.close();
 }
}
*/
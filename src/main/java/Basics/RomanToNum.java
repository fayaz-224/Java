package Basics;

import java.util.HashMap;
import java.util.Scanner;

public class RomanToNum {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int returnNumber = romanMap.get(s.charAt(s.length() - 1));
        for (int i = 0; i < s.length() - 1; i++) {  //imp: < len - 1
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                returnNumber -= romanMap.get(s.charAt(i));
            } else {
                returnNumber += romanMap.get(s.charAt(i));
            }
        }
        return returnNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(romanToInt(str));
        sc.close();
    }
}


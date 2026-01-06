package Strings.Advanced;

import java.util.HashMap;

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

        int total = 0;
        int prevValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = romanMap.get(s.charAt(i));
            if (value < prevValue) {
                total -= value;
            } else {
                total += value;
            }
            prevValue = value;
        }

        return total;

//--or--
//        int result = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int curr = map.get(s.charAt(i));
//            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;
//
//            if (curr < next) {
//                result -= curr;   // subtraction case (IV, IX, XL)
//            } else {
//                result += curr;
//            }
//        }
//        return result;

//--or--
//        int returnNumber = romanMap.get(s.charAt(s.length() - 1));  //from back to front
//        for (int i = 0; i < s.length() - 1; i++) {  //imp: i < len-1 as we are taking i+1 below
//            if (romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i + 1))) {
//                returnNumber += romanMap.get(s.charAt(i));
//            } else {
//                returnNumber -= romanMap.get(s.charAt(i));
//            }
//        }
//        return returnNumber;
    }

    public static void main(String[] args) {
        String str = "XXI";
        System.out.println(romanToInt(str));
    }
}

/*
Roman numerals use both addition and subtraction depending on the order of the symbols:

Example	Meaning	Explanation
VI	    6	    V (5) + I (1) = 6
IV	    4	    I (1) before V (5) means subtract → 5 - 1 = 4
XIV	    14	    X (10) + (V (5) - I (1)) = 14
XL	    40	    L (50) - X (10) = 40

So, if a smaller numeral appears before a larger one, we subtract it;
otherwise, we add it.
 */
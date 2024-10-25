package Array.Advance;

import java.util.Arrays;

public class BiggestPossibleNum {
    public static void main(String[] args) {
        String s = "4891";
        String[] arr = new String[s.length()];  //let's have a string array
        for (int i = 0; i < s.length(); i++) {
            arr[i] = String.valueOf(s.charAt(i));
        }

        System.out.println(largestNumber(arr)); //OP: 9841
        System.out.println(smallestNumber(arr));  //OP: 1489
    }

    public static String largestNumber(String[] arr) {
        //sorts the array in descending order based on the custom comparison logic provided in comparator
        //If num2 + num1 is lexicographically greater, it means num2 should come before num1 in the sorted array, resulting in descending order.
        Arrays.sort(arr, (num1, num2) -> (num2 + num1).compareTo(num1 + num2)); //Arrays.sort(arr, comparator);
        StringBuilder str = new StringBuilder();
        for (String s : arr) {
            str.append(s);
        }
        return str.toString();
    }

    public static String smallestNumber(String[] arr) {
        //This comparator sorts the elements in ascending order
        Arrays.sort(arr, (num1, num2) -> (num1 + num2).compareTo(num2 + num1));
        String str = "";
        for (String s : arr) {
            str += s;
        }
        return str;
    }
}

/*
//without using array functions and with int array
public static String BiggestPossibleNum(int[] nums) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            String num1 = Integer.toString(nums[i]) + Integer.toString(nums[j]);
            String num2 = Integer.toString(nums[j]) + Integer.toString(nums[i]);
            if (num1.compareTo(num2) < 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        result.append(nums[i]);
    }
    return result.toString();
}
 */

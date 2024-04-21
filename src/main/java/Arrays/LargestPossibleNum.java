package Arrays;

import java.util.Arrays;

public class LargestPossibleNum {
    public static void main(String[] args) {
        String[] arr = {"3", "1", "34", "9", "5"};
        System.out.println(largestNumber(arr)); //OP: 9534331
        System.out.println(smallestNumber(arr));  //OP: 1033459
    }

    public static String largestNumber(String[] arr) {
        //sorts the array in descending order based on the custom comparison logic provided in comparator
        //If num2 + num1 is lexicographically greater, it means num2 should come before num1 in the sorted array, resulting in descending order.
        Arrays.sort(arr, (num1,num2) -> (num2 + num1).compareTo(num1 + num2)); //Arrays.sort(arr, comparator);
        StringBuilder str = new StringBuilder();
        for (String s : arr) {
            str.append(s);
        }
        return str.toString();
    }

    public static String smallestNumber(String[] arr) {
        //This comparator sorts the elements in ascending order
        Arrays.sort(arr, (num1,num2) -> (num1 + num2).compareTo(num2 + num1));

        StringBuilder str = new StringBuilder();
        for (String s : arr) {
            str.append(s);
        }
        return str.toString();
    }
}

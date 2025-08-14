package Array.Basics;

import java.util.*;

//Please use the below two arrays as inputs and try to write a program addition of the two arrays.
//int arr1[] = { 9, 8, 9 };
//int arr2[] = { 9, 9 };
//For example 989+99=1088
//OP array = {1, 0, 8, 8}.
public class ArraySum {
    public static void main(String[] args) {
        int arr1[] = {9, 8, 9};
        int arr2[] = {9, 9};

        List<Integer> result = addArrays(arr1, arr2);
        System.out.println("Resulting array: " + result);
    }

    public static List<Integer> addArrays(int[] arr1, int[] arr2) {
        //iterate arrays in reverse order, as we perform addition from the last digit
        List<Integer> result = new ArrayList<>();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;

        // Add digits from right to left
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? arr1[i] : 0;
            int digit2 = j >= 0 ? arr2[j] : 0;
            int sum = digit1 + digit2 + carry;
            result.add(sum % 10);         // Add last digit of sum
            carry = sum / 10;             // Carry for next iteration
            i--;
            j--;
        }

        // Reverse result list to get correct order
        Collections.reverse(result);
        return result;

        //convert List to array if needed
        //int[] result = new int[result.size()];
        //for (int k = 0; k < result.size(); k++) {
        //    result[k] = result.get(result.size() - 1 - k); // reverse while copying
        //}
    }
}


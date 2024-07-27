package Basics;

import java.util.Arrays;

//Please use the below two arrays as inputs and try to write a program addition of the two arrays.
//int arr1[] = { 9, 8, 9 };
//int arr2[] = { 9, 9 };
//For example 989+99=1088
//OP array = {1, 0, 8, 8}.
public class ArraySum {
    public static void main(String[] args) {
        int arr1[] = {9, 8, 9};
        int arr2[] = {9, 9};

        // Reverse arrays as we perform addition from the last digit
        int[] revArr1 = reverseArray(arr1);
        int[] revArr2 = reverseArray(arr2);

        // Determine the maximum length required for the result array
        int maxLength = Math.max(revArr1.length, revArr2.length);

        // Result array to store the sum
        int[] result = new int[maxLength + 1]; // +1 in case there's a carry at the end

        int carry = 0;

        // Perform addition digit by digit
        for (int i = 0; i < maxLength; i++) {
            int digit1 = (i < revArr1.length) ? revArr1[i] : 0;
            int digit2 = (i < revArr2.length) ? revArr2[i] : 0;

            int sum = digit1 + digit2 + carry;
            result[i] = sum % 10; // Store the current digit in the result array
            carry = sum / 10;     // Update the carry
        }

        // If there's any remaining carry, add it to the result
        if (carry > 0) {
            result[maxLength] = carry;
        } else {
            // Trim the result array if no carry in the last step
            result = Arrays.copyOf(result, maxLength);
        }

        // Reverse the result array to get the correct order of digits
        result = reverseArray(result);

        System.out.println("Output array: " + Arrays.toString(result));
    }

    private static int[] reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return arr;
    }
}


package Array.Basics;

public class NextGreaterThanK {
    public static int findSmallestGreaterThanK(int[] arr, int k) {
        int result = Integer.MAX_VALUE;
        boolean found = false;

        for (int num : arr) {
            if (num > k && num < result) {
                result = num;
                found = true;
            }
        }

        return found ? result : -1;  // Return -1 if no such number exists
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 1, 6, 2};
        int k = 5;

        System.out.println(findSmallestGreaterThanK(arr, k));  // Output: 6
    }
}


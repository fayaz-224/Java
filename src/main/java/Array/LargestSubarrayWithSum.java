package Array;

import java.util.HashMap;

public class LargestSubarrayWithSum {
    public static int maxLenSubarray(int[] arr, int targetSum) {
        // HashMap to store (cumulative sum, first occurrence index) pairs
        HashMap<Integer, Integer> cumSumMap = new HashMap<>();
        int cumSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            cumSum += arr[i];

            // Check if the cumulative sum equals targetSum
            if (cumSum == targetSum) {
                maxLen = i + 1;
            }

            // If cumSum - targetSum is seen before, there is a subarray with sum targetSum
            if (cumSumMap.containsKey(cumSum - targetSum)) {
                maxLen = Math.max(maxLen, i - cumSumMap.get(cumSum - targetSum));
            }

            // If cumulative sum is not seen before, add it to the map
            if (!cumSumMap.containsKey(cumSum)) {
                cumSumMap.put(cumSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 5, -2, 3};
        int targetSum = 3;
        System.out.println("Length of the largest subarray: " + maxLenSubarray(arr, targetSum));

        int[] arr2 =  {15, 4, -2, 2, -3, 1, 3, 3, 0};
        int targetSum2 = 4;
        System.out.println("Length of the largest subarray: " + maxLenSubarray(arr2, targetSum2));
    }
}

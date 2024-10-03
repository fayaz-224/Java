package Array.Advanced;

import java.util.HashMap;

public class LargestSubarrayWithGivenSum {

    static int solve(int[] a, int targetSum) { //Brute Force Approach O(N^2)
        int  max = 0;
        for(int i = 0; i < a.length; ++i) {
            int sum = 0;
            for(int j = i; j < a.length; ++j) {
                sum += a[j];
                if(sum == targetSum) {
                    max = Math.max(max, j-i+1);  //j - i + 1 gives the length of the current subarray
                }
            }
        }
        return max;
    }

    static int maxLenSubarray(int[] arr, int targetSum) { //Optimal Approach O(N)
        // HashMap to store (cumulative sum, first occurrence index) pairs
        HashMap<Integer, Integer> cumSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == targetSum) {
                maxLen = i + 1;
            }

            // If (sum-targetSum) is seen before, there is a subarray with sum targetSum
            if (cumSumMap.containsKey(sum - targetSum)) {
                maxLen = Math.max(maxLen, i - cumSumMap.get(sum - targetSum));
            }

            // If sum is not seen before, add it to the map
            if (!cumSumMap.containsKey(sum)) {
                cumSumMap.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, -1, 5, -2, 3};
        int targetSum1 = 3;
        System.out.println("Length of the largest subarray: " + maxLenSubarray(arr1, targetSum1));

        int[] arr2 =  {15, 4, -2, 2, -3, 1, 3, 3, 0};
        int targetSum2 = 4;
        System.out.println("Length of the largest subarray: " + maxLenSubarray(arr2, targetSum2));

        int arr3[] = {9, -3, 3, -1, 6, -5};
        int targetSum3 = 0;
        System.out.println("Length of the largest subarray: " + maxLenSubarray(arr3, targetSum3));

    }
}

package Array.Advance;

import java.util.HashMap;

//find length of Longest SubArray Of Given target
//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class LongestSubArrayOfSizeK {

    //Works for positives, negatives, zeros.
    static int solve(int[] a, int k) { //Brute Force Approach O(N^2)
        int  max = 0;

        for(int i = 0; i < a.length; ++i) {
            int sum = 0;
            for(int j = i; j < a.length; ++j) {
                sum += a[j];
                if(sum == k) {
                    max = Math.max(max, j-i+1);  //j - i + 1 gives the length of the current subarray
                }
            }
        }
        return max;
    }

    //sliding window technique - works only for +ve numbers
    static int solve2(int[] a, int targetSum) {  //Optimal O(n)
        int left = 0, sum = 0;
        int maxLen = 0;

        for (int right = 0; right < a.length; right++) {
            sum += a[right];

            while (left <= right && sum > targetSum) { // Shrink from left while sum is too big
                sum -= a[left];
                left++;
            }

            if (sum == targetSum) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }

    //Prefix Sum + HashMap – Works for ANY integers (positives, zeros, negatives)
    static int maxLenSubarray(int[] arr, int targetSum) { //Optimal Approach O(N)

        HashMap<Integer, Integer> map = new HashMap<>(); // HashMap(cumulative sum, first occurrence index)
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == targetSum) {
                maxLen = i + 1;
            }

            // If (sum-targetSum) is seen before, there is a subarray with sum targetSum
            if (map.containsKey(sum - targetSum)) {
                maxLen = Math.max(maxLen, i - map.get(sum - targetSum));
            }

            // If sum is not seen before, add it to the map - i.e, store FIRST occurrence only
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, -1, 5, -2, 3};
        int targetSum1 = 3;
        System.out.println("Length of the largest subarray: " + maxLenSubarray(arr1, targetSum1)); //4

        int[] arr2 =  {15, 4, -2, 2, -3, 1, 3, 3, 0};
        int targetSum2 = 4;
        System.out.println("Length of the largest subarray: " + maxLenSubarray(arr2, targetSum2)); //7

        int arr3[] = {9, -3, 3, -1, 6, -5};
        int targetSum3 = 0;
        System.out.println("Length of the largest subarray: " + maxLenSubarray(arr3, targetSum3)); //5

    }
}

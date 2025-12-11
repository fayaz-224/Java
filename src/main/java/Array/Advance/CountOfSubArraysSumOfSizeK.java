package Array.Advance;

import java.util.HashMap;

//https://leetcode.com/problems/subarray-sum-equals-k/description/
//Find the total number of sub arrays whose sum equals to k. Same as LongestSubarraySumOfSizeK
public class CountOfSubArraysSumOfSizeK {

    public static int countSubarrays(int[] arr, int k) {  //Bruteforce - O(N^2)
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    //Optimal – O(n) Using Prefix Sum + HashMap (Standard)
    static int subArraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  //imp
        int sum = 0, count = 0;

        for (int n : nums) {
            sum += n;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);  //we need count so no if-check as in LongestSubArrayOfSizeK
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println("total number of sub arrays whose sum equals to k: "
                + subArraySum(arr, 3));  //op: 2
    }
}

/*
Example Trace for arr = [1, 2, 3], k = 3

| i | n | sum   | sum - k   | count | subNum               |
| - | - | ----- | --------- | ----- | -------------------- |
| 0 | 1 | 1     | -2        | 0     | {0=1, 1=1}           |
| 1 | 2 | 3     |  0        | 1     | {0=1, 1=1, 3=1}      |
| 2 | 3 | 6     |  3        | 2     | {0=1, 1=1, 3=1, 6=1} |

*/
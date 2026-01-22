package Array.Advance;

//Kadane algorithm is used to find the maximum sum of any continuous sub array
//https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubArraySum {

    static int maxSubarraySumBrute(int[] arr) {  // Bruteforce - O(N^2)
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    //Modern / Safer / Preferred - O(N)
    public static int maxSubArraySum1(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    //Classic / Older Style - O(N)
    public static int maxSubArraySum2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i =0;i < nums.length;i++) {
            sum += nums[i];
            if(sum > maxSum) {
                maxSum = sum;
            }

            if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    //To find the indexes of max sub array - O(N)
    public static long maxSubarraySumIndexes(int[] arr) {
        long maxi = Long.MIN_VALUE;
        long sum = 0;

        int start = 0;  // temporary start index
        int ansStart = 0; // final start index
        int ansEnd = 0;   // final end index

        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                start = i; // potential start of a new subarray
            }

            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        int length = ansEnd - ansStart + 1;
        System.out.println("\nmax subarray length = "+ length);

        System.out.print("Subarray: ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        return maxi;
    }

    public static void main(String args[]){
        int[] arr = {-4, -2, -7};
        System.out.println("max sum: " + maxSubArraySum2(arr)); //-2

        maxSubarraySumIndexes(arr); //-2
    }
}


/*
INPUT: [-2,1,-3,4,-1,2,1,-5,4]

Sub arrays and sums:
[4]	= 4
[4, -1]	= 3
[4, -1, 2]	= 5
[4, -1, 2, 1] = 6 ✅
[4, -1, 2, 1, -5, 4] = 5

The sub array [4, -1, 2, 1] has the maximum sum of 6.
 */
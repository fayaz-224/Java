package Array.Advance;

//Kadane algorithm is used to find the maximum sum of any continuous sub array
//https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubArraySum {

    public static int maxSubArraySum(int[] nums) {  //For arrays with at least one positive number
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i =0;i < nums.length;i++){
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

    public static long maxSubarraySum2(int[] arr) {
        long maxi = Long.MIN_VALUE; // stores the maximum sum
        long sum = 0;               // current subarray sum

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
        System.out.println("\nLength = "+ length);

        System.out.print("Subarray: ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        return maxi;
    }

    public static void main(String args[]){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("max sum: " + maxSubArraySum(arr)); //6

        System.out.println("max sum: " + maxSubarraySum2(arr)); //6
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
package Array.Advance;

//Kadane algorithm is used to find the maximum sum of any continuous sub array
//https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubArray {

    public static int maxSubArraySum(int[] nums) {  //For arrays with at least one positive number
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        //int maxStart = 0;
        //int maxLength = 0;

        for(int i =0;i < nums.length;i++){
            sum += nums[i];
            if(sum > maxSum) {
                maxSum = sum;
                //maxLength = i - maxStart + 1; //length of max subarray
            }
            if(sum < 0) {
                sum = 0;
                //maxStart = i + 1; //start index of max subarray
            }
        }
        return maxSum; //return maxLength;
    }

    public static int maxSubArraySum2(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String args[]){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("max sum: " + maxSubArraySum(arr)); //6

        int[] a = {-5, -2, -9, -1};
        System.out.println("max sum: " + maxSubArraySum(a)); //-1
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
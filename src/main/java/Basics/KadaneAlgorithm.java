package Basics;

public class KadaneAlgorithm {
    public static int maxSubArray(int[] nums) {
        //Kadane algorithm is used for finding the maximum subarray sum in a given array of integers.
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i =0;i < nums.length;i++){
            sum += nums[i];
            if(sum > max)
                max = sum;
            if(sum < 0)
                sum = 0;
        }
        return max;
    }

    public static void main(String args[]){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("max sum: " + maxSubArray(arr));

        int[] a = {1};
        System.out.println("max sum: " + maxSubArray(a));
    }
}

package Array;

//Kadane algorithm is used to find the maximum sub-array sum in a given array of integers.
public class KadaneAlgorithm {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
//        int maxStart = 0;
//        int maxEnd = 0;

        for(int i =0;i < nums.length;i++){
            sum += nums[i];
            if(sum > maxSum)
                maxSum = sum;   //maxEnd = i; -> for end index of max subarray
            if(sum < 0)
                sum = 0;    //maxStart = i + 1; -> for start index of max subarray
        }
        return maxSum;   //return new int[]{maxStart, maxEnd};
    }

    public static void main(String args[]){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("max sum: " + maxSubArray(arr));

        int[] a = {1};
        System.out.println("max sum: " + maxSubArray(a));
    }
}

package DSA.Prefix_Sufix;

//Prefix approach
//Kadane algorithm is used to find the maximum sum of any continuous sub array
public class KadaneAlgorithm {

    public static int maxSubArraySum(int[] nums) {  //For arrays with at least one positive number
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
//        int maxStart = 0;
//        int maxEnd = 0;

        for(int i =0;i < nums.length;i++){
            sum += nums[i];
            //maxSum = Math.max(maxSum, sum);
            if(sum > maxSum)
                maxSum = sum;   //maxEnd = i; -> for end index of max subarray
            if(sum < 0)
                sum = 0;    //maxStart = i + 1; -> for start index of max subarray
        }
        return maxSum;   //return new int[]{maxStart, maxEnd};
    }

    public static int maxSubArraySum2(int[] nums) {  //For arrays with all negative numbers
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
        System.out.println("max sum: " + maxSubArraySum2(a)); //-1
    }
}

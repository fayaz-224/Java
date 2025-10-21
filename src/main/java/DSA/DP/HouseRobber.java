package DSA.DP;

//Given an integer array nums representing the amount of money in each house, return the maximum amount of money you can rob tonight without alerting the police.
//No two adjacent houses should be robbed
public class HouseRobber {

    public static int rob(int[] nums) {  //space optimized
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int res = 0;
        int prev2prev = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        //we need alternate houses so starting from 2 as we considered 1st one
        for(int i=2; i<nums.length; i++){
            int take = prev2prev + nums[i];
            int noTake = prev;
            res = Math.max(take, noTake);

            prev2prev = prev;
            prev = res; //res means current position and max robbed amount
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {2,7,9,3,1};  // 2+9+1 = 12
        System.out.println("Max Robbed amount: "+ rob(nums));
    }
}

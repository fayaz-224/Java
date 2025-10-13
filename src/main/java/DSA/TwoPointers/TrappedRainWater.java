package DSA.TwoPointers;

//Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.
//https://takeuforward.org/data-structure/trapping-rainwater/
class TrappedRainWater { //Sum of water trapped between bars

    //2 pointer approach TC: O(N), SC: O(1)
    //https://leetcode.com/problems/trapping-rain-water/
    static int trap1(int[] height) {
        int left = 0, right = height.length - 1;

        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int waterTrapped = 0;

        while (left < right) {
            //the maximum height seen so far from both sides.
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax <= rightMax) {   //water will be held upto height smaller wall only
                waterTrapped += leftMax - height[left];  //leftMax is the highest wall to the left of the current position. If height[left] is lower than leftMax, then there's a “pit” that can collect water. The difference gives the actual volume of water that fits at that point. same from right.
                left++;
            } else {
                waterTrapped += rightMax - height[right];
                right--;
            }
        }
        return waterTrapped;
    }

    //DP approach TC = O(3*N), SC = O(N)+O(N)
    static int trap2(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {  //0,1,1,2,2,2,2,3,3,3,3,3 (forward)
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }

        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {  //1,3,3,3,3,3,3,3,3,3 (backwards)
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }

        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];  //imp
        }
        return waterTrapped;
    }

    public static void main(String args[]) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The trapped water is " + trap1(arr));
        //System.out.println("The trapped water is " + trap2(arr));
    }
}
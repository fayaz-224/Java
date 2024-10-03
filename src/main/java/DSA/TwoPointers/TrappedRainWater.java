package DSA.TwoPointers;

//Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.
//https://takeuforward.org/data-structure/trapping-rainwater/
class TrappedRainWater {

    //2 pointer approach TC: O(N), SC: O(1)
    //https://leetcode.com/problems/trapping-rain-water/solutions/5010489/java-clean-solution/
    static int trap1(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int waterTrapped = 0;

        while (left < right) {
            //Instead of storing leftMax, rightMax as shown in trap2(), use them directly
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax <= rightMax) {
                waterTrapped += leftMax - height[left];
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
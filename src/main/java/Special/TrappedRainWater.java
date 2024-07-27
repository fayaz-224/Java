package Special;

//Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.
//https://takeuforward.org/data-structure/trapping-rainwater/
class TrappedRainWater {
    //Brute force TC = O(N^2), SC = 1
    static int trap1(int[] arr) {
        int n = arr.length;
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int leftMax = 0, rightMax = 0;
            while (j >= 0) {
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }
            j = i;
            while (j < n) {
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }
            waterTrapped += Math.min(leftMax, rightMax) - arr[i];  //imp
        }
        return waterTrapped;
    }

    //Better solution TC = O(3*N), SC = O(N)+O(N)
    static int trap2(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {  //0,1,1,2,2,2,2,3,3,3,3,3 (forward)
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }

        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {  //3,3,3,3,3,3,3,3,2,2,2,1 (backwards)
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
        System.out.println("The trapped water is " + trap2(arr));

        int arr2[] = {4,2,0,3,2,5};
        System.out.println("The trapped water is " + trap2(arr2));
    }
}
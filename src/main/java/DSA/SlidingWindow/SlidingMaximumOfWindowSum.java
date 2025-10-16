package DSA.SlidingWindow;

//Find the Maximum SUM in continuous sub-array of length k.
public class SlidingMaximumOfWindowSum {

    static int bruteForceMaxSum(int[] arr, int k) {  //O(n*k)
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i+k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);  //max sum among all windows
        }

        return maxSum;
    }

    static int maxSumSlidingWindow(int[] arr, int k) {  //optimized code - O(n)
        int n = arr.length;
        if (n < k) return -1;  // not enough elements for one window

        int maxSum = 0;
        int windowSum = 0;

        // Calculate sum of first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window from start to end
        for (int i = k; i < n; i++) {
            // Remove the element going out and add the new element coming in - window moves forward
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 1, 2, 3, 4};
        int M = 2;
        System.out.println("Max sum of continuous subarray of length M: " + bruteForceMaxSum(arr1, M)); //7 -> [3, 4]
        //op: 5 (for M=1)
    }
}

/*
Example:
If arr = [2, 3, 6, 7, 9] and M=3, it computes sums: 2+3+6=11, 3+6+7=16, 6+7+9=22 -> returns 22.
 */
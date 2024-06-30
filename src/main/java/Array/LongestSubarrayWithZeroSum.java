package Array;

//An array containing both positive and negative integers,
//we have to find the length of the longest subarray with the sum of all elements equal to zero.
//Input: N = 6, array[] = {9, -3, 3, -1, 6, -5}
//Result: 5
//Explanation: The following subarrays sums to zero:
//{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
//Since we require the length of the longest subarray, our answer is 5.
public class LongestSubarrayWithZeroSum {

    static int solve(int[] a) {
        int  max = 0;
        for(int i = 0; i < a.length; ++i) {
            int sum = 0;
            for(int j = i; j < a.length; ++j) {
                sum += a[j];
                if(sum == 0) {
                    max = Math.max(max, j-i+1);  //imp: j - i + 1 is used to calculate the length of the current subarray
                }
            }
        }
        return max;
    }

    public static void main(String args[]) {
        int a[] = {9, -3, 3, -1, 6, -5};
        System.out.println(solve(a));
    }
}


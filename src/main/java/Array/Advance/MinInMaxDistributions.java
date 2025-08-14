package Array.Advance;

import java.util.Arrays;

//Divide an array into three non-empty groups.
//In each group we calculate the difference between the largest and smallest integer.
//Our goal is to return the lowest possible Maximum Difference as explained below.
class MinInMaxDistributions {  //zemoso interview question

    public int solution(int[] arr) {
        int n = arr.length;
        if (n < 3) return -1; // Must be at least 3 elements

        Arrays.sort(arr);
        int result = Integer.MAX_VALUE;
        // Since the array is sorted, you can directly pick
        for (int i = 1; i < n - 1; i++) {
            //Above indexes are to ensure all three groups are non-empty
            //if i = 0 -> Group 1 = arr[0 ... -1] → empty group → invalid
            //if i = n-1 -> Group 2 = arr[n-1 ... j-1] -> maybe empty, Group 3 = arr[j ... n-1] -> definitely empty since j > i
            for (int j = i + 1; j < n; j++) {
                int d1 = arr[i - 1] - arr[0];   // Max - Min of Group 1 (0 to i-1)
                int d2 = arr[j - 1] - arr[i];   // Max - Min of Group 2 (i to j-1)
                int d3 = arr[n - 1] - arr[j];   // Max - Min of Group 3 (j to n-1)

                int maxDiff = Math.max(d1, Math.max(d2, d3));
                result = Math.min(result, maxDiff);  //lowest possible Maximum Difference
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinInMaxDistributions obj = new MinInMaxDistributions();

        int[] testCase = {11, 5, 3, 12, 6, 8, 1, 7, 4};
        int result = obj.solution(testCase);

        System.out.println("Result: " + result); // Output: 3
    }
}

/*
For example, given A = [11, 5, 3, 12, 6, 8, 1, 7, 4], we can divide the elements into three groups as follows:
Distribution D1:
[1, 3, 4] − the difference between elements is 3;
[5, 6, 7, 8] − the difference is also 3;
[11, 12] − the difference is 1.
The maximum difference for D1 is 3.

Distribution D2:
[1,3] − the difference between elements is 2;
[4, 5, 6] − the difference is also 2;
[7, 8, 11, 12] − the difference is 5.
The maximum difference for D2 is 5.
Similarly, there can be approximately N^2 number of distributions possible, with each distribution having a Maximum Difference. In this example, 3 happens to be the lowest possible Maximum Difference among all distributions.
 */
package Special;

import java.util.Arrays;

//Divide them into three non-empty groups.
//In each group we calculate the difference between the largest and smallest integer.
//Our goal is to returns the lowest possible Maximum Difference as explained below.
class MinMaxInDistributions {  //zemoso interview question
    public int solution(int[] A) {
        int n = A.length;
        int result = Integer.MAX_VALUE;

        Arrays.sort(A);
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int leftMin = findMin(A, 0, i);
                int leftMax = findMax(A, 0, i);
                int middleMin = findMin(A, i, j);
                int middleMax = findMax(A, i, j);
                int rightMin = findMin(A, j, n);
                int rightMax = findMax(A, j, n);

                int maxDiff = Math.max(Math.max(leftMax - leftMin, middleMax - middleMin), rightMax - rightMin);

                result = Math.min(result, maxDiff);  //lowest possible Maximum Difference
            }
        }
        return result;
    }

    private int findMin(int[] A, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            min = Math.min(min, A[i]);
        }
        return min;
    }

    private int findMax(int[] A, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            max = Math.max(max, A[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        MinMaxInDistributions solution = new MinMaxInDistributions();

        int[] testCase = {11, 5, 3, 12, 6, 8, 1, 7, 4};
        int result = solution.solution(testCase);

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
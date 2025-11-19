package Array.Advance;

import java.util.Arrays;

//Determine the minimum number of steps needed to make all the piles the same height
public class MinStepsToEqualizePiles {
    public static int minStepsToEqualPiles(int[] heights) {
        int n = heights.length;
        if (n <= 1) return 0;

        Arrays.sort(heights);
        int steps = 0;
        // Iterate from the second element from end (the last element is the tallest)
        for (int i = n - 2; i >= 0; i--) {
            // If the current pile is shorter than the previous pile (which was taller),
            // it means we need to perform steps to lower the taller piles to this height.
            // The number of steps is equal to the number of piles that were taller than the current one.
            if (heights[i] < heights[i + 1]) {
                steps += (n - i - 1);
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        int[] h1 = {2, 3, 6};
        System.out.println("Minimum steps for {2, 3, 6}: " + minStepsToEqualPiles(h1)); // Expected: 3

        int[] h2 = {5, 2, 1, 2};
        System.out.println("Minimum steps for {5, 2, 1, 2}: " + minStepsToEqualPiles(h2)); // Expected: 4

        int[] h3 = {1, 1, 1};
        System.out.println("Minimum steps for {1, 1, 1}: " + minStepsToEqualPiles(h3)); // Expected: 0
    }
}

/*
Example:
Input: n = 3 boxes, boxesInPiles = [ 5, 2, 1 ]

Output: 3

Explanation:
After sorting:
heights = [1, 2, 5]
n = 3

Now the loop runs:
i	heights[i]	heights[i+1]	condition	    steps added	total steps
1	2	        5	            2 < 5 → true	(3 - 1 - 1) = 1
0	1	        2	            1 < 2 → true	(3 - 0 - 1) = 2

Final steps = 3.

That matches the total number of operations needed to "flatten" the piles by progressively reducing all taller ones.
 */
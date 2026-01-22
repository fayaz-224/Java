package DSA.Greedy;

import java.util.*;

//Minimum number of arrows to burst all balloons - greedy interval problem
public class MinArrows {

    public static int findMinArrowShots(int[][] points) {  //O(n log n)

        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort by end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));  //Comparator.comparingInt(a -> a[1])

        int arrows = 1;
        int arrowPos = points[0][1];  //Always shoot the arrow at the end of the earliest-ending balloon. That position gives the maximum overlap with future balloons.
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        int[][] balloons = {
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        };

        System.out.println(findMinArrowShots(balloons)); // 2
    }
}


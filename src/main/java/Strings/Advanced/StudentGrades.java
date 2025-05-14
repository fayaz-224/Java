package Strings.Advanced;

import java.util.HashMap;
import java.util.Map;

//Return highest average among all
public class StudentGrades {

    public static int bestAverageGrade(String[][] scores) {
        if (scores == null || scores.length == 0) {
            return 0;
        }

        // Map to keep track of total scores and the number of scores for each student
        Map<String, int[]> scoreRecords = new HashMap<>();

        for (String[] scorePair : scores) {
            String student = scorePair[0];
            int score = Integer.parseInt(scorePair[1]);
            if (!scoreRecords.containsKey(student)) {
                scoreRecords.put(student, new int[]{score, 1}); // Store total score and count
            } else {
                int[] current = scoreRecords.get(student);
                current[0] += score; // Update total score
                current[1] += 1; // Update count
            }
        }

        int maxAverage = Integer.MIN_VALUE;

        for (int[] values : scoreRecords.values()) {
            int average = values[0] / values[1]; //one is sum, other is count
            if (average > maxAverage) {
                maxAverage = average;
            }
        }

        return maxAverage;
    }

    public static void main(String[] args) {
        String[][] input = {
                {"Bobby", "87"},
                {"Charles", "100"},
                {"Eric", "64"},
                {"Charles", "92"}
        };
//
        System.out.println(bestAverageGrade(input));  // Output: 87
    }
}

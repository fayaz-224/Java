package Array.Advance;

//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/
//Return the number of pairs of songs for which their total duration in seconds is divisible by 60
public class PairsOfSongs {

    public static int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[60];
        int count = 0;

        for (int t : time) {
            int rem = t % 60;
            if (rem == 0)
                count += remainder[rem];
            else
                count += remainder[60 - rem];

            remainder[rem]++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] songDurations = {30, 20, 150, 100, 40};
        System.out.println("Number of pairs divisible by 60: " + numPairsDivisibleBy60(songDurations));
        // Output should be 3 pairs: (20, 40), (20, 100), (150, 30)
    }
}

/*
Example 1:
Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60

Example 2:
Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 */
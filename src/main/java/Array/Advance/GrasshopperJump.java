package Array.Advance;

//A grasshopper is jumping on a numbered staircase where the bottom stair is numbered 1, the next is 2, and so on. The grasshopper can jump up or down according to an array of jump values.
//For each jump in the array:
//If jumps[i] > 0, the grasshopper jumps jumps[i] steps up.
//If jumps[i] < 0, the grasshopper jumps |jumps[i]| steps down.
//Find the lowest possible stair number (startingStair) where the grasshopper can begin and remain on the staircase (stair number ≥ 1) throughout all jumps.
public class GrasshopperJump {

    public static int findStartingStair(int[] jumps) {
        int current = 0;
        int minReached = 0;

        for (int jump : jumps) {
            current += jump;
            if (current < minReached) {
                minReached = current;
            }
        }

        // Minimum starting stair so that the lowest position stays ≥ 1
        return 1 - minReached;
    }

    public static void main(String[] args) {
        int[] jumps = {1, -4, -2, 3};
        System.out.println(findStartingStair(jumps)); // Output: 6
    }
}

/*
Example:
jumps = [1, -4, -2, 3]

current:  1,  -3,  -5,  -2
minReached = -5
startingStair = 1 - (-5) = 6 ✅

So, if startingStair = 6:
The grasshopper remains on the staircase (stair ≥ 1) throughout all jumps. 6 is the lowest possible starting stair that satisfies this condition.

for better understanding. Directly check the answer below:
Start at stair 6
Jump 1 step up to stair 7
Jump 4 steps down to stair 3
Jump 2 steps down to stair 1
Jump 3 steps up to stair 4
 */
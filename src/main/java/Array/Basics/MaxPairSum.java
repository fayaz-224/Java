package Array.Basics;

//From an array divide in a pair of 2 numbers then sum each pair, find the which pair gives maximum total sum?
public class MaxPairSum {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 6, 7, 9};

        int maxSum = Integer.MIN_VALUE;
        int[] maxPair = new int[2];

        for (int i = 0; i < numbers.length - 1; i++) {  //Checks every overlapping pair (sliding window). Use i += 2 in for-loop for non-overlapping pairs (fixed)
            int sum = numbers[i] + numbers[i + 1];

            if (sum > maxSum) {
                maxSum = sum;
                maxPair[0] = numbers[i];
                maxPair[1] = numbers[i + 1];
            }
        }

        System.out.println("Max adjacent pair: [" + maxPair[0] + ", " + maxPair[1] + "] → Sum: " + maxSum);  //[7, 9] → Sum: 16
    }
}


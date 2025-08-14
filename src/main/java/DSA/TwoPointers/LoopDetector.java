package DSA.TwoPointers;

//Floyd's Tortoise and Hare Algorithm
public class LoopDetector {

    public static int findLoopLength(int[] arr, int startIndex) {   //count Length Of Cycle in arr
        if (startIndex < 0 || startIndex >= arr.length || arr.length == 0) {
            return -1;
        }

        int slow = startIndex, fast = startIndex;

        while (true) {
            slow = arr[slow];
            if (slow < 0 || slow >= arr.length) {
                return -1;
            }
            fast = arr[arr[fast]];
            if (fast < 0 || fast >= arr.length || arr[fast] < 0 || arr[fast] >= arr.length) {
                return -1;
            }

            if (slow == fast) {
                // Loop detected, calculate the length of the loop
                int loopLength = 0;
                do {
                    slow = arr[slow];  //moving slow till it reaches its position, to calculate cycle
                    loopLength++;
                } while (slow != fast);

                return loopLength;
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] array1 = {1, 2, 3, 4, 2}; // Loop exists starting from index 2
        System.out.println(findLoopLength(array1, 0)); // Output: 3 (Loop length is 3)

        int[] array2 = {1, 2, 3, 4, -1}; // No loop
        System.out.println(findLoopLength(array2, 0)); // Output: -1

        int[] array3 = {1, 2, 0}; // Loop exists starting from index 0
        System.out.println(findLoopLength(array3, 0)); // Output: 3 (Loop length is 3)
    }
}


/*
Array 1: {1, 2, 3, 4, 2}
Initial indices: slow starts at 0, fast starts at 0.

array[slow] = array[0] = 1 -> slow = 1
array[array[fast]] = array[array[0]] = array[1] = 2 -> fast = 2

array[slow] = array[1] = 2 -> slow = 2
array[array[fast]] = array[array[2]] = array[3] = 4 -> fast = 4

array[slow] = array[2] = 3 -> slow = 3
array[array[fast]] = array[array[4]] = array[2] = 3 -> fast = 3 (Now slow == fast)
Now the slow and fast pointers meet at index 3, confirming a loop. To calculate the loop length:

Start from slow = 3;
slow = array[slow] = array[3] = 4 -> loopLength = 1
slow = array[slow] = array[4] = 2 -> loopLength = 2
slow = array[slow] = array[2] = 3 -> loopLength = 3
Since slow has now met fast, the loop length is 3.
 */
package Array.Advance;

//Maximum of all subarrays of size K - find max element in each subarray of size k
public class SlidingMaximum {
    static void printKMax(int arr[], int k) {  //O(nk)
        int max, n = arr.length;
        for (int i = 0; i <= n - k; i++) {
            max = arr[i];
            for (int j = i+1; j < i+k; j++) { //i+1 as we're already assuming arr[i] as max before
                if (arr[j] > max)
                    max = arr[j];
            }
            System.out.print(max + " ");  //max in each window
        }
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3; //size of subarrays

        printKMax(arr, k);
    }
}

//Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
//Output: 3 3 4 5 5 5 6
//Explanation: Maximum of 1, 2, 3 is 3
//             Maximum of 2, 3, 1 is 3
//             Maximum of 3, 1, 4 is 4 etc..


/*
//The deque stores indices of array elements, not the elements themselves, and ensures:
//Front of deque = index of maximum in current window.
//Deque is in decreasing order of values from front to back.

import java.util.*;
public class MaxOfSubarrays {  //TC: O(n)
    public static void printMaxOfSubarrays(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            // Remove indices out of current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            // Remove smaller elements from the back
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.pollLast();

            dq.offerLast(i); // add current element index

            // Print max of current window
            if (i >= k - 1)
                System.out.print(arr[dq.peekFirst()] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        printMaxOfSubarrays(arr, k);
    }
}
 */
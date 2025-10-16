package DSA.SlidingWindow;

import java.util.*;

//find max element in each subarray of size k
//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingMaximum {

    static int[] printMax(int arr[], int k) {  //O(nk) - bruteforce
        int max, n = arr.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            max = arr[i];
            for (int j = i+1; j < i+k; j++) { //i+1 as we're already assuming arr[i] as max before
                if (arr[j] > max)
                    max = arr[j];
            }
            list.add(max);  //max in each window
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] printMax2(int[] arr, int k) {  //O(n)
        Deque<Integer> dq = new LinkedList<>(); // stores indices, not values
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // Remove indices that are out of current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            // Remove smaller elements from the back (they’ll never be needed)
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.pollLast();

            dq.offerLast(i); // add current element index

            // Print max of current window
            if (i >= k - 1)
                res.add(arr[dq.peekFirst()]);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;

        System.out.println(Arrays.toString(printMax2(arr, k)));
    }
}

//Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
//Output: 3 3 4 5 5 5 6
//Explanation: Maximum of 1, 2, 3 is 3
//             Maximum of 2, 3, 1 is 3
//             Maximum of 3, 1, 4 is 4 etc..


/*
The deque stores indices of array elements, not the elements themselves, and ensures:
    Front of deque = index of maximum in current window.
    Deque is in decreasing order of values from front to back.
*/

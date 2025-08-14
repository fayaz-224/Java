package Array.Advance;

import java.util.PriorityQueue;

public class MaxMinElement_Kth { //TC: O(N log K)

    public static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //Min Heap

        for (int num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }
        return minHeap.peek(); // k-th largest
    }

    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);  //Max Heap - we can also use Collections.reverseOrder()
        for (int x : nums) {
            maxHeap.add(x);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove largest
            }
        }
        return maxHeap.peek(); // k-th smallest
    }

    public static void main(String[] args){
        int[] arr = {7, 10, 4, 3, 20, 15};  //Sorted order for better underStanding: 3, 4, 7, 10, 15, 20
        int k = 3;
        System.out.println("Kth largest: "+ findKthLargest(arr, k));  //10

        System.out.println("Kth Smallest: "+ findKthSmallest(arr, k));  //7
    }
}
/*
EXPLANATION: kth largest
    Add 7 → heap = [7]
    Add 10 → heap = [7, 10]
    Add 4 → heap = [4, 10, 7]
    Now size = 3, continue:
    Add 3 → heap = [3, 10, 7, 4] → size = 4 → remove 3 → heap = [4, 10, 7]
    Add 20 → heap = [4, 10, 7, 20] → size = 4 → remove 4 → heap = [7, 10, 20]
    Add 15 → heap = [7, 10, 20, 15] → size = 4 → remove 7 → heap = [10, 15, 20]

    Final heap: [10, 15, 20] → Top (peek) = 10, which is the 3rd largest.
 */

/*
Bruteforce: O(N log N)
public static int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
}

public static int findKthSmallest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[k - 1];
}
 */
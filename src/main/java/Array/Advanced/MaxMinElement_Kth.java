package Array.Advanced;

import java.util.PriorityQueue;

public class MaxMinElement_Kth {

    //Approach - 1
    public static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();  //Min Heap
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(pq.peek()<arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    //Approach - 2
    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);  //Max Heap
        for (int x : nums) {
            minHeap.add(x);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args){
        int[] arr = { 10, 5, 4, 3, 48, 6, 2, 33, 11, 53, 20 };  //Sorted order foe better underStanding: 2,3,4,5,6,10,11,20,33,48,53
        int k = 4;
        System.out.println("Kth largest: "+ findKthLargest(arr, k));  //20

        System.out.println("Kth Smallest: "+ findKthSmallest(arr, k));  //5
    }
}

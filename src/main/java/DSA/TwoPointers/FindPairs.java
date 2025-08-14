package DSA.TwoPointers;

import java.util.*;

//Set approach TC:O(n), SC: O(n)
public class FindPairs {

    //2 pointers approach - opp. direction  TC: O(n logn), SC: O(1)
    public static void findPairsWithSum1(int[] arr, int k) {
        Arrays.sort(arr); // Sort the array first
        ArrayList<List> pairs = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == k) {
                List pair = Arrays.asList(arr[left], arr[right]);
                pairs.add(pair);
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(pairs);
    }

    public static void findPairsWithSum2(int[] arr, int k) {
        Set<Integer> seen = new HashSet<>();
        Set<String> pairs = new HashSet<>();

        for (int num : arr) {
            int complement = k - num;
            if (seen.contains(complement)) {
                // Use a sorted order to avoid duplicates
                String pair = Math.min(num, complement) + "," + Math.max(num, complement);
                pairs.add(pair);
            } else
                seen.add(num);
        }

        System.out.println(pairs);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 4, 5, 7};
        int k = 5;
        findPairsWithSum1(arr, k);
    }
}


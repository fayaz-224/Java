package Array.Advance;

import java.util.*;

class LeadersInArray {

    static ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (nums.length == 0) {
            return ans;
        }

        // Last element of the array is always a leader
        int max = nums[nums.length - 1];
        ans.add(nums[nums.length - 1]);

        // Check elements from right to left
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }

        // Reverse the list to match the required output order
        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3, 0, 6};

        ArrayList<Integer> ans = leaders(nums);

        System.out.print("Leaders in the array are: ");
        for (int leader : ans) {
            System.out.print(leader + " ");
        }
        System.out.println();
    }
}

/*
Input:
 arr = [10, 22, 12, 3, 0, 6]
Output:
 22 12 6

Explanation:
 6 is a leader because there are no elements after it.
12 is greater than all the elements to its right (3, 0, 6), and 22 is greater than 12, 3, 0, 6, making them leaders as well.
 */
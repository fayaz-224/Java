package Array.Advance;

import java.util.*;

//Find all elements in an array that appear more than N/2 and N/3 times.
public class MajorityElement {

    //Approach - 1 : Use Hashmap and find freq of each element. Then find the element count > N/2

    //Approach - 2: Boyer–Moore Voting algorithm - Only one majority element can exist ie, > n/2 + > n/2 = > n
    public static int majorityElementNby2(int[] nums) {
        int n = nums.length;
        int candidate = 0;
        int count = 0;

        //Step 1: Candidate Selection (Boyer–Moore Voting)
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        //Step 2: Verification - We need this to validate our candidate, As above code might give an invalid candidate when no majority element exist.
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate) {
                cnt1++;
            }
        }
        if (cnt1 > (n / 2)) {
            return candidate;
        }

        return -1;
    }

    //At most, there can be 2 such elements that appear more than N/3 times. Because 3 × (N/3) > N, so having 3 such elements would exceed the array length
    public static List<Integer> majorityElementNby3(int[] nums) {
        int n = nums.length;
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;  //counts are NOT the real frequencies of the candidates, They are only relative vote balances

        // Step 1: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify candidates, As we don’t know for sure if those candidates really appear more than n/3 times — they’re just possible.
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        int[] num = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("N/2: " + majorityElementNby2(num)); // 2

        int[] nums = {1, 2, 3, 1, 2, 1, 1};
        System.out.println("N/3: " + majorityElementNby3(nums)); // [1]
    }
}


/*
nums = [2, 2, 1, 1, 1, 2, 2]
n = 7
n/2 = 3.5
2 appears 4 times
1 appears 3 times

Since 4 > 3.5,
✅ 2 is the majority element.

 */
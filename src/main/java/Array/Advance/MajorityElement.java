package Array.Advance;

import java.util.*;

//Find all elements in an array that appear more than N/2 and N/3 times.
//Boyer–Moore Voting algorithm
public class MajorityElement {

    public static int majorityElementNby2(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (num == candidate) {
                count++;
            } else if (count == 0) {
                candidate = num;
                count = 1; //count=1 as it has one supporter so far (itself). But if the new candidate starts with count=0, the next non-matching number becomes the new candidate
            } else
                count--;
        }
        return candidate;
    }

    public static List<Integer> majorityElementNby3(int[] nums) {
        int n = nums.length;
        int candidate1 = 0, candidate2 = 0; //At most, there can be 2 such elements that appear more than N/3 times. Because 3 × (N/3) > N, so having 3 such elements would exceed the array length.
        int count1 = 0, count2 = 0;

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

        // Step 3: Collect valid results
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
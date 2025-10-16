package Array.Advance;

import java.util.HashMap;

//https://leetcode.com/problems/subarray-sum-equals-k/description/
//Find the total number of sub arrays whose sum equals to k.
public class CountOfSubArraysSumEqualsK {

    static int subArraySum(int[] nums, int k) {
        HashMap<Integer, Integer> subNum = new HashMap<>();
        subNum.put(0, 1);  //imp
        int total = 0, count = 0;

        for (int n : nums) {
            total += n;

            if (subNum.containsKey(total - k)) {
                count += subNum.get(total - k);
            }
            subNum.put(total, subNum.getOrDefault(total, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println("total number of sub arrays whose sum equals to k: "
                + subArraySum(arr, 3));  //op: 2
    }
}

/*
Example Trace for arr = [1, 2, 3], k = 3

| i | n | total | total - k | count | subNum               |
| - | - | ----- | --------- | ----- | -------------------- |
| 0 | 1 | 1     | -2        | 0     | {0=1, 1=1}           |
| 1 | 2 | 3     |  0        | 1     | {0=1, 1=1, 3=1}      |
| 2 | 3 | 6     |  3        | 2     | {0=1, 1=1, 3=1, 6=1} |

*/
package Array.Advance;

// Each integer appears exactly once except A which appears twice and B which is missing. find the repeating and missing numbers A and B.
public class MissingRepeatingNumbers {

    public static int[] findMissingRepeatingNumbers(int[] a) {  //SC: O(N)
        int n = a.length;
        int[] temp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            temp[a[i]]++;   //ex: Code encounters the element 3 at index 0. It updates temp[3] by incrementing its value from 0 to 1.
        }

        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {  //array a[] contains numbers from 1 to n. Index 0 is unused (not part of valid number range)
            if (temp[i] == 2) repeating = i;
            else if (temp[i] == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        return new int[]{missing, repeating};
    }

    public static int[] findMissingRepeatingNumbers2(int[] nums) {  //SC: O(1)
        int n = nums.length;
        int repeating = -1, missing = -1;

        // Step 1: Mark visited numbers in-place using negation
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1; // convert value → index

            if (nums[index] < 0) { // If already negative → we’ve seen this number before → repeating
                repeating = Math.abs(nums[i]);
            } else { // Mark as visited by negating
                nums[index] = -nums[index];
            }
        }

        // Step 2: Find missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {  //positive number is the answer
                missing = i + 1;
                break;
            }
        }

        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans = findMissingRepeatingNumbers(a);
        System.out.println("The missing & repeating numbers are: "
                + ans[0] + ", " + ans[1]);  //op: 8, 5
    }
}

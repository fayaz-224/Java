package Array.Advance;

import java.util.*;

//TC: O(N3*log(M)), where N = size of the array, M = no. of elements in the set.
//SC: O(2 * no. of the quadruplets)+O(N)
public class Sum4 {

    public static List<List<Integer>> fourSum(int[] nums, int target) { //Better Approach
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();

        // checking all possible quadruplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    // to avoid integer overflow:
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;

                    if (hashset.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int)fourth);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                    hashset.add((long) nums[k]);
                }
            }
        }
        return new ArrayList<>(st);  //convert set to list
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans = fourSum(nums, target);

        //System.out.println(ans.stream().collect(Collectors.toList()));
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}

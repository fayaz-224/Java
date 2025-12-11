package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/description/
//Generate all subsets
public class Subsets {

    //Approach-1 (Recursive Include/Exclude)
    List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //Arrays.sort(nums);  //use sort along with while below, if we need to avoid duplicates
        createSubset(nums, 0, res, new ArrayList<>());
        return res;
    }
    private void createSubset(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);  //take
        createSubset(nums, index + 1, res, subset);
        subset.remove(subset.size() - 1); //backtrack
        //while (index + 1 < nums.length && nums[index] == nums[index + 1]) {  //to Skip duplicates
        //    index++;
        //}
        createSubset(nums, index + 1, res, subset); //no take
    }

    //Approach-2 (Backtracking with for loop)
    List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums); //use sort along with if below, if we need to avoid duplicates
        backtrack(nums, 0, list, new ArrayList<>());
        return list;
    }
    private void backtrack(int [] nums, int start, List<List<Integer>> list , List<Integer> subset){
        list.add(new ArrayList<>(subset));

        for(int i = start; i < nums.length; i++){
            //if(i > start && nums[i] == nums[i-1]) continue; //to skip duplicates
            subset.add(nums[i]);
            backtrack(nums, i + 1, list, subset);
            subset.remove(subset.size() - 1);  //backtrack
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();

        int[] nums = {1,2,3};
        System.out.println(s.subsets(nums));

        int[] nums2 = {1,2,2};
        System.out.println(s.subsets2(nums2));  //to avoid duplicates Un-comment above logic
    }
}

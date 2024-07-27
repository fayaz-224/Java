package Basics;

//Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
//Brute Force Approach
public class Sum2 { //O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target)
                    return new int[]{i, j};  //return true;
            }
        }
        return new int[]{-1, -1};  //return false;
    }

    public static void main(String[] args){
        int arr[] = {2,6,5,8,11};
        int res[] = twoSum(arr, 22);
        System.out.println("[" +res[0] + "," + res[1] +"]");
    }
}

/*
//Optimal Approach
class Solution {    // O(N) + O(N*logN)
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target)
               return new int[]{left, right};
            else if (sum < target)
               left++;
            else
               right--;
        }
        return new int[]{-1, -1};
    }
}
*/

/*
import java.util.HashMap;

public class FindPairsSumEquals11 {
    public static void main(String[] args) {
        int[] arr = {0, 14, 0, 4, 7, 8, 3, 5, 7};
        findPairsWithSum(arr, 11);
    }

    public static void findPairsWithSum(int[] arr, int targetSum) {
        Set<List<Integer>> res = new HashSet<>();
        Set<List<Integer>> set = new HashSet<>();

        for (int num : arr) {
            int complement = targetSum - num;
            if (set.contains(complement)) {
                List<Integer> temp = Arrays.asList(num, complement);
                temp.sort(null);
                res.add(temp);
            }
            set.put(num);
        }

        System.out.println(res);
    }
}
 */
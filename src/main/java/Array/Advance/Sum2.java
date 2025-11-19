package Array.Advance;

//Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
//Brute Force Approach
/*
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
        int res[] = twoSum(arr, 14);
        System.out.println("[" +res[0] + "," + res[1] +"]");
    }
}
*/


import java.util.*;

//Set approach TC:O(n) SC: O(n)
public class Sum2 {
    public static void main(String[] args) {
        int[] arr = {0, 14, 0, 4, 7, 8, 3, 5, 7};
        System.out.println(findPairsWithSum(arr, 11));
    }

    public static Set<List<Integer>> findPairsWithSum(int[] arr, int targetSum) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = targetSum - num;
            if (set.contains(complement)) {
                List<Integer> temp = Arrays.asList(num, complement);
                Collections.sort(temp); //temp.sort(null);
                res.add(temp);
            }
            set.add(num);  //else block not needed as set removes duplicates anyway
        }

        return res;
    }
}


/*
public class FindPairsTwoPointers { //2 pointers approach TC: O(n logn), SC: O(1)
    public static void findPairsWithSum(int[] arr, int k) {
        Arrays.sort(arr); // Sort the array first

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == k) {
                System.out.println(arr[left] + ", " + arr[right]);
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 4, 5, 7};
        int k = 5;
        findPairsWithSum(arr, k);
    }
}
 */
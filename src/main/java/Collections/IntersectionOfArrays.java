package Collections;

import java.util.*;

//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
public class IntersectionOfArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        // Use a HashMap to store the counts of each element in nums1
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // List to store the intersection elements
        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                intersection.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
        //--or-- return intersection.toArray(new Integer[0]);  //we have to change return type from int to Integer
// --or-- Convert the list to an array as below
//        int[] result = new int[intersection.size()];
//        for (int i = 0; i < intersection.size(); i++) {
//            result[i] = intersection.get(i);
//        }
//        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersect(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [2, 2]

        int[] n1 = {1, 2, 1};
        int[] n2 = {2, 2};
        int[] r = intersect(n1, n2);
        System.out.println(Arrays.toString(r)); // Output: [2]
    }
}


/*
public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while(i < n && j < m){
            int a = nums1[i], b= nums2[j];
            if(a == b){
                list.add(a);
                i++;
                j++;
            }else if(a < b){
                i++;
            }else{
                j++;
            }
        }
        int[] ret = new int[list.size()];
        for(int k = 0; k < list.size();k++) ret[k] = list.get(k);
        return ret;
    }
 */
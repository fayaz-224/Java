package Matrix;

import java.util.*;

//Brute force: O(N X M) - using 2 for loops to find target
//https://leetcode.com/problems/search-a-2d-matrix-ii/

//Optimal sol - using Binary search
public class SearchIn2DMtx {
    static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n-1;

        while(row< m && col >-1){
            if(matrix[row][col]== target) return true;
            if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

        boolean result = searchMatrix(matrix, 5);
        System.out.println(result);
    }
}



/*
//Another way
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int[] row : matrix) {
            // Check if the target is within the range of current row
            if (target >= row[0] && target <= row[row.length - 1]) {
                if (binarySearch(row, target, 0, row.length - 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

}
 */
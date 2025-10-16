package Matrix;

//https://leetcode.com/problems/search-a-2d-matrix-ii/

//Brute force: O(N X M) - using two for loops to find target
//Binary search: O(log(m * n)) - use if matrix is sorted in ascending order from left to right.
//Staircase Search: (O(m + n)) - use If the matrix has rows and columns sorted independently (below)
public class SearchIn2DMtx {
    static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowLeft = 0, rowRight = cols-1;

        while(rowLeft < rows && rowRight >= 0){
            if(matrix[rowLeft][rowRight]== target)
                return true;
            if(matrix[rowLeft][rowRight] > target)
                rowRight--;
            else
                rowLeft++;
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
public class MatrixSearch {  //binary search approach

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = matrix[mid / cols][mid % cols];  // convert 1D index to 2D

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));  // Output: true
    }
}
 */
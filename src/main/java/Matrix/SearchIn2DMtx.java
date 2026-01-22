package Matrix;

//https://leetcode.com/problems/search-a-2d-matrix-ii/
//Brute force: O(N X M) - use if mtx is un-sorted by using 2 for loops to find target
public class SearchIn2DMtx {
    //Staircase Search: (O(m + n)) - use if the matrix has rows and columns sorted independently
    static boolean searchMatrix(int[][] matrix, int target) {
        int rowLeft = 0, rowRight = matrix[0].length - 1;

        while (rowLeft < matrix.length && rowRight >= 0) {
            if (matrix[rowLeft][rowRight] == target)
                return true;
            if (matrix[rowLeft][rowRight] > target)
                rowRight--;
            else
                rowLeft++;
        }
        return false;
    }

    //Binary search: O(log(m * n)) - use if the matrix is fully sorted from left to right.
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = matrix[mid / cols][mid % cols];  // In a binary search on a 2D matrix, we often treat the matrix as if it were a 1D array. This line converts that 1D index to 2D coordinates, so we can access the element in the matrix.

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
        int[][] matrix = {{1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}};

        System.out.println(searchMatrix(matrix, 5));  //true

        int[][] m2 = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        System.out.println(searchMatrix2(m2, 3));  // true
    }
}
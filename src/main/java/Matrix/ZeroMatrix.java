package Matrix;

//Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
//Space Complexity: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
/*
1 0 3
0 0 0
7 0 9
 */
public class ZeroMatrix {

    public static void setZeroes(int[][] matrix) { //SC: O(m+n)
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Arrays to keep track of rows and columns to be zeroed
        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        // Find positions of all zeros
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    //mark indexes of row, col
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Set matched rows,cols to zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                          {4, 0, 6},
                          {7, 8, 9}};

        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

/*
//without extra space - SC: O(1)
public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Flag to track if first row and first column should be zeroed
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Check if first row and first column has any zeros - we need these later as markers
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Use first row and col as markers for zero rows/cols
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // mark row
                    matrix[0][j] = 0;  // mark col
                }
            }
        }

        // Step 3: Set elements to zero based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Zero the first row and fist column if needed
        if(firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
        if(firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
 */
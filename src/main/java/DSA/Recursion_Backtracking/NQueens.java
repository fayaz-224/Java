package DSA.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;
//The N-Queens problem is a classic problem in which you have to place N queens on an NxN chessboard in such a way that no two queens threaten each other.
// Queens can move horizontally, vertically, and diagonally.
//https://leetcode.com/problems/n-queens/description/
public class NQueens {  //O(N! * N).

    //It initializes an empty chessboard and calls the solveNQueensHelper method to find all valid solutions.
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '_';
            }
        }
        solveNQueensHelper(board, 0, result);
        return result;
    }

    //It uses backtracking to recursively explore all possible placements of queens on the chessboard.
    private void solveNQueensHelper(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(constructSolution(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueensHelper(board, row + 1, result);
                board[row][col] = '_';
            }
        }
    }

    //checks if a queen can be placed at a given position without conflicting with other queens.
    private boolean isValid(char[][] board, int row, int col) {
        // Check if there is a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check if there is a queen in the same diagonal (upper left)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check if there is a queen in the same diagonal (upper right)
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //It constructs a valid solution from the chessboard configuration.
    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            solution.add(new String(board[i]));
        }
        return solution;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> solutions = nQueens.solveNQueens(4);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}


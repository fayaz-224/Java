package DSA.Recursion;

//https://leetcode.com/problems/word-search/description/
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
public class WordSearch {

    static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = backtrack(board, word, i, j, 0);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    static boolean backtrack(char[][] board, String word, int i, int j, int index) {
        //If the entire word has been found, return true
        if (index == word.length()) {
            return true;
        }

        // Out of bounds or mismatch
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        board[i][j] = '*';  //visited

        if (backtrack(board, word, i + 1, j, index + 1) ||
                backtrack(board, word, i - 1, j, index + 1) ||
                backtrack(board, word, i, j + 1, index + 1) ||
                backtrack(board, word, i, j - 1, index + 1)) {
            return true;
        }

        //Restore the original character
        board[i][j] = word.charAt(index);

        return false;  // If the word is not found
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}

package DSA.BFS_DFS;

//In a given grid, 1=land & 0=water. count no. of islands covered by water
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Check if current cell is out of bounds or not land
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != '1') {
            return;
        }

        // Mark visited cell
        grid[row][col] = '0';

        // Explore neighboring cells recursively
        dfs(grid, row + 1, col); // Down
        dfs(grid, row - 1, col); // Up
        dfs(grid, row, col + 1); // Right
        dfs(grid, row, col - 1); // Left


        /*To find perimeter of island
            int perimeter = 0;
            perimeter += dfs(grid, row + 1, col); // Down
            perimeter += dfs(grid, row - 1, col); // Up
            perimeter += dfs(grid, row, col + 1); // Right
            perimeter += dfs(grid, row, col - 1); // Left

            return primeter;
         */
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumberOfIslands solution = new NumberOfIslands();
        System.out.println("Number of islands: " + solution.numIslands(grid)); // Output: 3
    }
}


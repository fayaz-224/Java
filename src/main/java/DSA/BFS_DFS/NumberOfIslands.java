package DSA.BFS_DFS;

//In a given grid, 1=land & 0=water. count no. of islands covered by water
//https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {  //DFS
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j); //mark connected land as '0' to avoid recounting as diff land
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Check if current cell is out of bounds or not a land
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

            return perimeter;
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

/*
public static int numIslands(char[][] grid) {  //BFS
    if (grid == null || grid.length == 0) return 0;

    int rows = grid.length;
    int cols = grid[0].length;
    int count = 0;

    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            if (grid[r][c] == '1') {
                count++;
                bfs(grid, r, c);   // run BFS to sink it
            }
        }
    }
    return count;
}

private static void bfs(char[][] grid, int r, int c) {
    int rows = grid.length;
    int cols = grid[0].length;

    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{r, c});

    grid[r][c] = '0'; // mark as visited

    while (!queue.isEmpty()) {
        int[] cell = queue.poll();
        for (int[] d : directions) {
            int nr = cell[0] + d[0];
            int nc = cell[1] + d[1];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                grid[nr][nc] = '0'; // sink neighbor
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
 */
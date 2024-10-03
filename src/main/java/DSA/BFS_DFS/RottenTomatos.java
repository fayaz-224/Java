package DSA.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

//2  -  represents a rotten orange
//1  -  represents a Fresh orange
//0  -  represents an Empty Cell
//Every minute, if a Fresh Orange is adjacent to a Rotten Orange in 4-direction ( upward, downwards, right, and left ) it becomes Rotten.
//Return the minimum number of minutes required such that none of the cells has a Fresh Orange. If it's not possible, return -1.

class RottenTomatos {   //O(nxn) x 4

    public static int orangesRotting(int[][] grid) {  //BFS
        if(grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshTomatos = 0;

        //Put the position of all rotten oranges in queue
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                if(grid[i][j] == 1) {
                    freshTomatos++; //count the number of fresh oranges
                }
            }
        }

        if(freshTomatos == 0)
            return 0;
        int countMinutes = 0;
        int[][] directions = {{-1, 0}, {1,0}, {0,-1}, {0,1}};

        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i<size ; i++) {
                int[] current = queue.poll();
                for(int[] dir: directions) {  //4 neighbours
                    //row and column of the neighbours
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
                        continue; //visited

                    grid[x][y] = 2;
                    freshTomatos--;
                    queue.offer(new int[]{x , y});
                }
            }
            if(queue.size() != 0) {  //!queue.isEmpty()
                countMinutes++;
            }
        }
        return freshTomatos == 0 ? countMinutes : -1; //if all fresh tomatoes are not rotten return -1
    }

    public static void main(String args[]) {
        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required " + rotting);
    }
}
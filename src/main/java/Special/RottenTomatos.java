package Special;

import java.util.LinkedList;
import java.util.Queue;

//2  -  represents a rotten orange
//1  -  represents a Fresh orange
//0  -  represents an Empty Cell
//Every minute, if a Fresh Orange is adjacent to a Rotten Orange in 4-direction ( upward, downwards, right, and left ) it becomes Rotten.
//Return the minimum number of minutes required such that none of the cells has a Fresh Orange. If it's not possible, return -1.

class RottenTomatos {   //O(nxn) x 4
    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;

        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                if(grid[i][j] != 0) {
                    count_fresh++;
                }
            }
        }

        if(count_fresh == 0) return 0;
        int countMin = 0, cnt = 0;
        int dx[] = {0, 0, 1, -1}; //we can give in any order
        int dy[] = {1, -1, 0, 0}; //combining both dx, dy gives directions: dx[0],dy[0] = right, dx[1],dy[1] = left, dx[2],dy[2] = down, dx[3],dy[3] = up

        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt += size;
            for(int i = 0 ; i<size ; i++) {
                int[] point = queue.poll();
                for(int j = 0; j<4; j++) {  //4 neighbours
                    //row and column of the neighbours
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
                        continue; //visited

                    grid[x][y] = 2;
                    queue.offer(new int[]{x , y});
                }
            }
            if(queue.size() != 0) {  //queue.isEmpty()
                countMin++;
            }
        }
        return count_fresh == cnt ? countMin : -1; //if all fresh tomatoes are not rotten return -1
    }

    public static void main(String args[]) {
        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required " + rotting);
    }
}
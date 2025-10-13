package DSA.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

//2  -  represents a rotten orange
//1  -  represents a Fresh orange
//0  -  represents an Empty Cell
//Every minute, if a Fresh Orange is adjacent to a Rotten Orange in 4-direction ( upward, downwards, right, and left ) it becomes Rotten.
//Return the minimum number of minutes required such that none of the cells has a Fresh Orange. If it's not possible, return -1.
//https://leetcode.com/problems/rotting-oranges/
class RottenOranges {

    public static int orangesRotting(int[][] grid) {  //BFS - both TC & SC = O(mxn)
        if(grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j}); //Put the positions of all rotten oranges in queue
                }
                if(grid[i][j] == 1) {
                    freshOranges++; //count the number of fresh oranges
                }
            }
        }

        if(freshOranges == 0) return 0;

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

                    if(x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2; //mark fresh as rotten to avoid revisiting
                        freshOranges--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            if(!queue.isEmpty()) {
                countMinutes++;
            }
        }

        return freshOranges == 0 ? countMinutes : -1; //if all fresh tomatoes are not rotten return -1
    }

    public static void main(String args[]) {
        int arr[][]={{2, 1, 1},
                     {1, 1, 0},
                     {0, 1, 0}};
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required " + rotting);
    }
}
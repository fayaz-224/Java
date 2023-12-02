package Arrays;
//90 - clockwise direction

public class MtxRotation {
	public static void main(String[] args) {
	  int[][] mat= {{1,2,3},{4,5,6},{7,8,9}};
		
		int n = mat.length;        
      int[][] m1 = new int[n][n];
      
      //rotated 90 degreee clockwise
      for(int i =0;i<n;i++){
          for(int j =0;j<n;j++)
        	  m1[i][j] = mat[n-j-1][i];
       }
      for(int i =0;i<n;i++){
          for(int j =0;j<n;j++)
        	  System.out.print(m1[i][j]+ " ");
          System.out.println();
      }
	}
}


/*
import java.io.*;
 
class MtxRotation {	//without using another matrix
    static int N = 4;
 
    // Function to rotate the matrix 90 degree clockwise
    static void rotate90Clockwise(int arr[][])
    {
        
        for (int i = 0; i < N; i++)
        {
            for (int j = N - 1; j >= 0; j--)
                System.out.print(arr[j][i] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        int arr[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 } };
        rotate90Clockwise(arr);
    }
}

*/
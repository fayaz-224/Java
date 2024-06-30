package Matrix;
//90 - clockwise direction
//this can also be achieved by doing transpose and reverse elements in the row, if u don't want to use another mtx.
class MtxRotation { 	//without using another matrix
    static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {   //transpose
            for (int j = i; j < n; j++) {  //imp: j=i
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {   //reverse elements in rows
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j -1] = temp;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}

/*
public class MtxRotation {
	public static void main(String[] args) {
	  int[][] mat= {{1,2,3},{4,5,6},{7,8,9}};

      int n = mat.length;
      int[][] m1 = new int[n][n]; //new mtx

      //rotated 90 degreee clockwise
      for(int i =0;i<n;i++){
          for(int j =0;j<n;j++)
              m1[i][j] = mat[n - j - 1][i]; //imp
      }
      for(int i =0;i<n;i++){
          for(int j =0;j<n;j++)
        	  System.out.print(m1[i][j]+ " ");
          System.out.println();
      }
	}
}


class MtxRotation {
    static void rotate90Clockwise(int arr[][], int N){
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 0; j--)
                System.out.print(arr[j][i] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 } };
        rotate90Clockwise(arr, arr.length);
    }
}

*/
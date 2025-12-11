package Matrix;

// where rows become columns, columns become rows
/* 
public class TransposeMtx {
   public static void main(String args[]) {
      int m, n, i, j;
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the number of rows and columns of matrix");
      m = in.nextInt();
      n = in.nextInt();
      int matrix[][] = new int[m][n];//original matrix
     
      System.out.println("Enter the elements of matrix");
      for (i = 0; i < m; i++){
         for (j = 0; j < n; j++) 
            matrix[i][j] = in.nextInt();
      }
      
      int transpose[][] = new int[n][m]; //transpose matrix
      for (i = 0; i < m; i++){
         for (j = 0; j < n; j++)     
            transpose[j][i] = matrix[i][j];        
      }
      
      System.out.println("Transpose of the matrix:");
      for (i = 0; i < n; i++){	//n x m
         for (j = 0; j < m; j++)
        	 System.out.print(transpose[i][j]+" ");
         System.out.println();
      }
      
   }
}
*/

public class TransposeMtx {	 //without using another mtx
	public static void main(String[] args) {
		
		int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
		int n = arr.length;
		
 		for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++) {  //for (int j=0; j<i; j++) {
                  int temp = arr[i][j]; 
                  arr[i][j] = arr[j][i]; 
                  arr[j][i] = temp;
             }
 	    }

 		System.out.print("Transpose matrix is \n");
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) 
                System.out.print(arr[i][j] + " "); 
            System.out.print("\n");
        }
	}
}

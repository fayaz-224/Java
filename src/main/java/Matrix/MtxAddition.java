package Matrix;

import java.util.Scanner;

public class MtxAddition
{
   public static void main(String args[]) {
       int i, j, n;
       Scanner scan = new Scanner(System.in);
	   n=scan.nextInt();  //for add & sub, dimensions should be same
	   
       int a[][] = new int[n][n];
       int b[][] = new int[n][n];
       int c[][] = new int[n][n];
       
       System.out.print("Enter Matrix 1 Elements : ");
       for(i=0; i<n; i++) {
           for(j=0; j<n; j++) {
               a[i][j] = scan.nextInt();
           }
       }
	   
       System.out.print("Enter Matrix 2 Elements : ");
       for(i=0; i<n; i++) {
           for(j=0; j<n; j++) {
               b[i][j] = scan.nextInt();
           }
       }
	   
       System.out.print("adding Matrices (i.e. Matrix1 + Matrix2)...\n");
       for(i=0; i<n; i++) {
           for(j=0; j<n; j++) {
               c[i][j] = a[i][j]+ b[i][j];
               
               //c[i][j]=a[i][j] - b[i][j];    for matrix subtraction
                                    
               System.out.print(c[i][j]+ " ");
           }
           System.out.println();
       }
   }
}
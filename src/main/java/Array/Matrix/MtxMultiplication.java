package Array.Matrix;
import java.util.Scanner;

public class MtxMultiplication {
   public static void main(String args[]) {
	   
       int i, j, k, m, n, p , q, sum=0;
       Scanner scan = new Scanner(System.in);
	   m=scan.nextInt();
	   n=scan.nextInt();	   
       int a[][] = new int[m][n]; //1st matrix 
       
       System.out.print("Enter Matrix 1 Elements : ");
       for(i=0; i<m; i++) {
           for(j=0; j<n; j++) {
               a[i][j] = scan.nextInt();
           }
       }
       
       p=scan.nextInt();
       q=scan.nextInt();
       
       if (n != p)
    	   System.out.println("The matrices can't be multiplied with each other.\n");
       else {
           int b[][] = new int[p][q]; //2nd matrix

           System.out.print("Enter Matrix 2 Elements : ");
           for(i=0; i<p; i++) {
               for(j=0; j<q; j++) {
                   b[i][j] = scan.nextInt();
               }
           }

           System.out.print("multiplying Matrices ...\n");
           int c[][] = new int[m][q]; //multiplied matrix
           for(i=0; i<m; i++) {
               for(j=0; j<q; j++) {
                   for (k = 0; k < p; k++) {  //n or p bcoz, its the common dimension
                      sum = sum + a[i][k]*b[k][j];
                   }

                   c[i][j] = sum;
                   sum = 0;
                   System.out.print(c[i][j]+ " ");
               }
               System.out.println();
           }
       }
   }
}
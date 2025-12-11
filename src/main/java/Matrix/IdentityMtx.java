package Matrix;

import java.util.Scanner;

/*
 verify that the given mtx is Identity mtx or not
 	1	0	0
 	0	1	0
 	0	0	1
*/
public class IdentityMtx {
    public static void main(String args[]) {
    	 boolean flag=true;
    	 
        Scanner ob=new Scanner(System.in);
        int n=3;
        int mat[][]=new int[n][n];
        
        System.out.println("Enter elements of matrix.");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                mat[i][j]=ob.nextInt();
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if((i==j && mat[i][j]!=1) || (i!=j && mat[i][j]!=0)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) // If flag is false, break out of the outer loop. no need to check others
                break;
        }
        if(flag)
            System.out.println("The matrix entered is an Identity Matrix.");
        else
            System.out.println("The matrix entered is not an Identity Matrix.");
        
        ob.close();
    }
}

/* 
 //-----generating a identity matrix------
 
public class IdentityMtx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the matrix :");
        int size = sc.nextInt();
       
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}

*/
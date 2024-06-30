package Patterns;
//Pascal’s triangle is a pattern in which each element is equal to
// the sum of the two numbers immediately above it.

//    1 
//   1 1 
//  1 2 1 
// 1 3 3 1 
//1 4 6 4 1 

public class Pascal {
	public static void main(String[] args) {
	    int n=5;
	    for(int i=1;i<=n;i++) {
	        for(int j=i;j<n;j++)
	        	System.out.print(" ");
	        
	        int k=1;
            for(int j=1;j<=i;j++) {
                System.out.print(k+" ");
                k = (k*(i-j)) / j; 	//main logic
            }
            System.out.println();
        }
	}
}
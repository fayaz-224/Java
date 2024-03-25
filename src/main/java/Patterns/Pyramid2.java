package Patterns;
/*
* 
** 
*** 
**** 
***** 
**** 
*** 
** 
*
*/
public class Pyramid2 {

	public static void main(String[] args) {
		int n = 5;
		for(int i=1;i<n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=n;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

//Approach 2
//		for (int row = 0; row < 2*n; row++) {
//			int totalColsInRow = row>n ? 2*n-row : row;
//			for (int col = 0; col < totalColsInRow; col++) {
//				System.out.print("* ");
//			}
//			System.out.println();
//		}
	}
}

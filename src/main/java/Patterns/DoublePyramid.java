package Patterns;

//to want pyramids in straight way use only one row for loop
//to want pyramids in downwards use 2 rows for loops
/*
    *        *
   ***      ***
  *****    *****
 *******  *******
******************
*/
public class DoublePyramid {  //or Mirrored pyramids
	public static void main(String args[]) {
		int n=5;

		for(int i=1;i<=n;i++) {
			for(int j=i;j<n;j++) {		//1st pyramid of model 1
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			
			for(int j=i;j<n;j++) { 	//2nd pyramid of model 2
				System.out.print("  ");  // 2 spaces to maintain symmetry or use below code
			}
//			for(int j=i;j<n;j++) {
//				System.out.print(" ");
//			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}			
}

package Patterns;

//    A
//   BBB
//  CCCCC
// DDDDDDD
//EEEEEEEEE
public class CharPyramid {
	public static void main(String args[]){ 
		int n=5, k='A'; //we can put k inside 1st for loop also
		for(int i=1;i<=n;i++) {

			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print((char)k);
			}
			k++;
			System.out.println();
		}
	}
}

package Patterns;
//    A
//   BAB
//  CBABC
// DCBABCD
//EDCBABCDE

public class CharPyramid3 {

	public static void main(String[] args) {
		int n=5, k='A';
		for(int i=1;i<=n;i++) {
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<i;j++) {
				System.out.print((char)k--);
			}
			for(int j=1;j<=i;j++) {
				System.out.print((char)k++);
			}
			//without using extra variable (k)
//			for (int j = i; j >= 1; j--) {
//				System.out.print((char)('A' + j - 1));
//			}
//			for (int j = 2; j <= i; j++) {
//				System.out.print((char)('A' + j - 1));
//			}
			System.out.println();
		}

	}
}

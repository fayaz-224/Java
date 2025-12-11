package Patterns;

class CharPatterns {

	//    A
	//   BBB
	//  CCCCC
	// DDDDDDD
	//EEEEEEEEE
	private static void charPyramid1(int n) {
		int k='A'; //we can put k inside 1st for loop also
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

	//AAAAA
	//CCCC
	//EEE
	//GG
	//I
	private static void charPyramid2(int n) {
		for(int i=1,k='A'; i<=n; i++,k+=2) {
			for (int j = i; j <= n; j++)
				System.out.print((char)k);

			System.out.println();
		}
	}

	//    A
	//   BAB
	//  CBABC
	// DCBABCD
	//EDCBABCDE
	private static void charPyramid3(int n) {
		int k = 'A';

		for (int i = 1; i <= n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j < i; j++) {
				System.out.print((char) k--);
			}
			for (int j = 1; j <= i; j++) {
				System.out.print((char) k++);
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

	//Z
	//AA
	//YYY
	//AAAA
	//FFFFF
	private static void charPyramid4() {
		String s = "FAYAZ";
		int n = s.length();
		int K = n-1;

		for(int i=1;i<=n;i++) {
			for (int j = 1; j <= i; j++)
				System.out.print(s.charAt(K));

			K--;
			System.out.println();
		}
	}

	public static void main(String[] args){
		int n = 5;
		charPyramid1(n);
		charPyramid2(n);
		charPyramid3(n);
		charPyramid4();
	}
}


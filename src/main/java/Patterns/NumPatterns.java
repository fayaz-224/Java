package Patterns;

class NumPatterns {

	//    1
	//   123
	//  12345
	// 1234567
	//123456789
	private static void numPyramid1(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print(j); //imp
			}
			System.out.println();
		}
	}

	//    1
	//   212
	//  32123
	// 4321234
	//543212345
	private static void numPyramid2(int n) {
		for (int i = 1; i <= n; i++) {

			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int j = i; j >= 1; j--) {  //imp - Print descending numbers
				System.out.print(j);
			}
			for (int j = 2; j <= i; j++) {  //Print ascending numbers
				System.out.print(j);
			}
			System.out.println();
		}
	}

	//54321
	//5432
	//543
	//54
	//5
	private static void numPyramid3(int n) {
		for (int i = 1; i <= n; i++) {
			int k=5;
			for (int j = i; j <= n; j++)
				System.out.print(k--);

			System.out.println();
		}
	}

	//12345
	//1234
	//123
	//12
	//1
	private static void numPyramid4(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print((j - i + 1));  //alternative to above approach
			}
			System.out.println();
		}

	}

	//1
	//12
	//123
	//1234
	//12345
	private static void numPyramid5(int n) {
		for(int i=1;i<=n;i++) {
			for (int j = 1; j <= i; j++)
				System.out.print(j);

			System.out.println();
		}
	}

	//1
	//0 1
	//1 0 1
	//0 1 0 1
	//1 0 1 0 1
	private static void numPyramid6(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if ((i + j) % 2 == 0)
					System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
	}

	//    1
	//   222
	//  33333
	// 4444444
	//555555555
	// 6666666
	//  77777
	//   888
	//    9
	private static void numPyramid7(int n) {
		int k=1;
		for(int i=1;i<=n;i++,k++) {	//k++ imp
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print(k);
			}
			System.out.println();
		}

		//reverse the view of us.
		for(int i=n-1;i>=1;i--,k++) {	//k-- for decreasing nums
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print(k);
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		int n=5;
		numPyramid1(n);
		numPyramid2(n);
		numPyramid3(n);
		numPyramid4(n);
		numPyramid5(n);
		numPyramid6(n);
		numPyramid7(n);
	}
}

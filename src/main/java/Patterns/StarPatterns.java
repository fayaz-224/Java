package Patterns;

public class StarPatterns {

	//*
	//**
	//***
	//****
	//*****
	private static void leftIncreasingPattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print("*");

			System.out.println();
		}
	}
	//	  *
	//   **
	//  ***
	// ****
	//*****
	private static void rightIncreasingPattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = i; j < n; j++)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");

			System.out.println();
		}
	}

	//*****
	//****
	//***
	//**
	//*
	private static void leftDecreasingPattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++)  // or for(int j=1;j<=n-i;j++)
				System.out.print("*");

			System.out.println();
		}
	}
	//*****
	// ****
	//  ***
	//   **
	//    *
	private static void rightDecreasingPattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++)
				System.out.print(" ");
			for (int j = i; j <= n; j++)
				System.out.print("*");

			System.out.println();
		}
	}

	// * * * * *
	// * * * * *
	// * * * * *
	// * * * * *
	// * * * * *
	private static void square(int n){
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) { //imp
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	//    *
	//   ***
	//  *****
	// *******
	//*********
	private static void increasingPyramid(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) { //logic for pyramid shape
				System.out.print("*");
			}

			System.out.println();
		}
	}

	//*********
	// *******
	//  *****
	//   ***
	//    *
	private static void decreasingPyramid(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {  //j<i for no space in the beginning of pyramid
				System.out.print(" ");
			}
			for (int j = i; j < n; j++) {
				System.out.print("*");
			}
			for (int j = i; j <= n; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}

	//*
	//* *
	//* * *
	//* * * *
	//* * * * *
	//* * * *
	//* * *
	//* *
	//*
	private static void sidePyramid(int n) {
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

	//    *        *
	//   ***      ***
	//  *****    *****
	// *******  *******
	//******************
	private static void doublePyramid(int n) { //to want pyramids in straight way use only one for loop, for downwards pyramids use 2 rows for loops
		for(int i=1;i<=n;i++) {
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}

			for(int j=i;j<n;j++) {
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

	//    *
	//   ***
	//  *****
	// *******
	//*********
	// *******
	//  *****
	//   ***
	//    *
	private static void diamond(int n){
		for(int i=1;i<=n;i++) {
			for(int j=i;j<n;j++)
				System.out.print(" ");
			for(int j=1;j<=2*i-1;j++)
				System.out.print("*");

			System.out.println();
		}

		for(int i=n-1;i>=1;i--) {	//reverse the view of us.
			for(int j=i;j<n;j++)
				System.out.print(" ");
			for(int j=1;j<=2*i-1;j++)
				System.out.print("*");

			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n=5;
		leftIncreasingPattern(n);
		rightIncreasingPattern(n);
		leftDecreasingPattern(n);
		rightDecreasingPattern(n);
		square(n);

		increasingPyramid(5);
		decreasingPyramid(5);
		sidePyramid(5);

		doublePyramid(n);
		diamond(n);
	}
}

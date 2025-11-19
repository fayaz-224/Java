package Patterns;

public class BasicPatterns {
	private static void increasingPattern(int n) {
		for(int i=1;i<=n;i++) {	//left increasing pattern
			for(int j=1;j<=i;j++)
				System.out.print("*");

			System.out.println();
		}

		for (int i = 1; i <= n; i++) {   //right increasing pattern
			for (int j = i; j < n; j++)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");

			System.out.println();
		}
	}

	private static void decreasingPattern(int n) {
		for(int i=1;i<=n;i++){  //left decreasing pattern
			for(int j=i;j<=n;j++)  // or for(int j=1;j<=n-i;j++)
				System.out.print("*");

			System.out.println();
		}

		for (int i = 1; i <= n; i++) {  //right decreasing pattern
			for (int j = 1; j < i; j++)
				System.out.print(" ");
			for (int j = i; j <= n; j++)
				System.out.print("*");

			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n=5;
		increasingPattern(n);
		System.out.println("---------");
		decreasingPattern(n);
	}
}

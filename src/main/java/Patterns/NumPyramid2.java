package Patterns;

//    1
//   212
//  32123
// 4321234
//543212345
public class NumPyramid2 {
    public static void main(String[] args) {
        int n = 5;
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
}


//    1
//   121
//  12321
// 1234321
//123454321
/*
public class NumPyramid2 {
	public static void main(String[] args) {
		int n=5;

		for(int i=1;i<=n;i++) {
			int k=1; 		//imp
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<i;j++) {
				System.out.print(k++);
			}
			for(int j=1;j<=i;j++) {
				System.out.print(k--);
			}
			System.out.println();
	    }
    }
}
*/
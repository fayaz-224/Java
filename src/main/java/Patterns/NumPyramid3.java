package Patterns;

/*
54321
5432
543
54
5
*/
public class NumPyramid3 {	//TCS question

	public static void main(String[] args) {
		int n=5;

        for (int i = 1; i <= n; i++) {
			int k=5;
            for (int j = i; j <= n; j++)
				System.out.print(k--);
			
			System.out.println();
		}
	}
}

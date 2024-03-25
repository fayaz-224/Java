package Patterns;
/*
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
 */
class Diamond{ 	 
public static void main(String args[]){ 
	int n=5;
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

//Approach-2
//	for (int row = 0; row < 2 * n; row++) {
//		int totalColsInRow = row > n ? 2 * n - row: row;
//
//		for (int s = 0; s < n - totalColsInRow; s++) {
//			System.out.print(" ");
//		}
//		for (int col = 0; col < totalColsInRow; col++) {
//			System.out.print("* ");
//		}
//		System.out.println();
//	}
}
}

/*  //old way
public class Diamond {
	public static void main(String[] args) {
		int n=5;
		for(int i=1;i<n;i++) 	//upper pattern
		{
			for(int j=i;j<n;j++) 
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) 
			{
				System.out.print("*");
			}
			for(int j=1;j<i;j++) 	//remove = to make it pyramid
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=1;i<=n;i++) 	//lower pattern
		{
			for(int j=1;j<i;j++) 
			{
				System.out.print(" ");
			}
			for(int j=i;j<=n;j++) 
			{
				System.out.print("*");
			}
			for(int j=i;j<n;j++) 
			{
				System.out.print("*");
			}
			System.out.println();
	}
}
}

*/

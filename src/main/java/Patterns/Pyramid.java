package Patterns;
/*
    *
   ***
  *****
 *******
*********
*/
public class Pyramid {
	public static void main(String[] args) {
		int n=5;
        for (int i = 1; i <= n; i++) {    //increasing py
            for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
            for (int j = 1; j <= 2 * i - 1; j++) { //logic for pyramid shape
				System.out.print("*");
			}

			System.out.println();
        }

//		for(int i=1;i<=n;i++) 	//decreasing py
//		{
//			for(int j=1;j<i;j++) //j<i for no space in the beggining of pyramid
//			{
//				System.out.print(" ");
//			}
//			for(int j=i;j<n;j++)
//			{
//				System.out.print("*");
//			}
//			for(int j=i;j<=n;j++)
//			{
//				System.out.print("*");
//			}
//
//			System.out.println();
//		}
	}
}

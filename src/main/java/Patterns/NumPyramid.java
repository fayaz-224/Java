package Patterns;
//    1
//   123
//  12345
// 1234567
//123456789

class NumPyramid { 	 
	public static void main(String[] args){
		int n=5;
		for(int i=1;i<=n;i++) {
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) { //imp
					System.out.print(j);
			}
			System.out.println();
		}
	}
}

/*
public class NumPyramid 
{
	public static void main(String[] args) {
		int n=5;
		
		for(int i=1;i<=n;i++) 
		{
			int k=1; 		//imp
			for(int j=i;j<n;j++) 
			{
				System.out.print(" ");
			}
			for(int j=1;j<i;j++) 
			{
				System.out.print(k++);
			}
			for(int j=1;j<=i;j++) 
			{
				System.out.print(k++);
			}
			System.out.println();
	}
}
}
*/
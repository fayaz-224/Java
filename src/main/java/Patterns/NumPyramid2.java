package Patterns;
//    1
//   121
//  12321
// 1234321
//123454321

public class NumPyramid2
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
				System.out.print(k--);
			}
			System.out.println();
	}
}
}

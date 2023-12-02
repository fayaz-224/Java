package Patterns;
//    A
//   BBB
//  CCCCC
// DDDDDDD
//EEEEEEEEE

public class CharPyramid {
	public static void main(String args[]){ 
		int n=5;
		for(int i=1,k='A';i<=n;i++,k++) 
		{
			for(int j=i;j<n;j++) 
			{
				System.out.print(" ");
			}
				for(int j=1;j<=2*i-1;j++) 
				{
					System.out.print((char)k);
				}
				
				System.out.println();
			}
		}
}

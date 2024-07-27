package Patterns;
/* diamond pattern with increasing nums
    1
   222
  33333
 4444444
555555555
 6666666
  77777
   888
    9
*/

public class NumDiamond {
	public static void main(String[] args) {
		int n=5,k=1;
		for(int i=1;i<=n;i++,k++) 	//k++ imp
		{
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print(k);
			}
			System.out.println();
		}
		
		//reverse the view of us.
		for(int i=n-1;i>=1;i--,k++) 	//k-- for decreasing nums
		{
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print(k);
			}
			System.out.println();
		}
	}
}




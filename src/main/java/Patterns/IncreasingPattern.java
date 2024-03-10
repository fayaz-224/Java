package Patterns;

// imp 1
public class IncreasingPattern {

	public static void main(String[] args) {
		int n=5;
//		for(int i=1;i<=n;i++)	//left increasing pattern
//		{
//			for(int j=1;j<=i;j++)
//				System.out.print("*");
//
//			System.out.println();
//		}

        for (int i = 1; i <= n; i++)    //right increasing pattern
		{
            for (int j = i; j < n; j++)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
				System.out.print("*");

            System.out.println();
		}
	}
}

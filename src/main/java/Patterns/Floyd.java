package Patterns;

//1
//2 3 
//4 5 6 
//7 8 9 10
public class Floyd {
	public static void main(String[] args) {
        int n = 4, num = 1;    //put num outside for-loop
		for(int i=1;i<=n;i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(num++ + " ");

			System.out.println();
		}
	}
}

/*
//10 9 8 7
//6 5 4
//3 2
//1
public class Floyd {  //reverse floyd
	public static void main(String[] args) {
		int n=4,k=10;	//place k outside of for loop
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=n;j++) {
				System.out.print(k-- + " ");
			}
			System.out.println();
		}
	}
}
*/
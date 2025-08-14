package Patterns;

//AAAAA
//CCCC
//EEE
//GG
//I
class CharPyramid2 {
	public static void main(String[] args){
		int n=6;
		for(int i=1,k='A'; i<=n; i++,k+=2)
		{
			for (int j = i; j <= n; j++)
				System.out.print((char)k);

			System.out.println();
		}
	}
}
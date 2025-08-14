package Patterns;
/*
F
AA
YYY
AAAA
ZZZZZ
*/

/*
public class StringPattern {
	public static void main(String args[]){
		String s= "FAYAZ";
		int n=s.length();
		int k=0;
		for(int i=1;i<=n;i++,k++){
			for(int j=1;j<=i;j++){
				System.out.print(s.charAt(k)); //at k place we can write i also with i=0 in the first place
			}
			System.out.println();
		}
}
}
*/

/*
Z
AA
YYY
AAAA
FFFFF
*/

public class CharPyramid4 {
	public static void main(String[] args){
		String s = "FAYAZ";
		int n=s.length();
		
		for(int i=1,k=n-1;i<=n;i++,k--) {
            for (int j = 1; j <= i; j++)
				System.out.print(s.charAt(k));

            System.out.println();
		}
	}
}

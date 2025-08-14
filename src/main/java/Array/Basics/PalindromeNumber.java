package Array.Basics;

// A number that is same even after reversing it.
/*
class PalindromeNumber {
	public static void main(String args[]) {
		int k,sum=0,temp;    
		int n=151;
		temp=n;    
		while(n>0) {
			k = n%10;
			sum = (sum*10)+k;
			n = n/10;
		}
		if(temp==sum)    
			System.out.println("palindrome number ");    
		else    
			System.out.println("not palindrome");    
	}  
}  
*/

class PalindromeNumber { 

	static int recursive_func(int n, int sum) {
		if (n < 10) {
			return sum * 10 + n;
		} else {
			int k = n % 10;
			sum = (sum * 10) + k;
			n = n/10;
			return recursive_func(n, sum);
		}
	}

	public static void main(String[] args) {
		int n = 123464321;
		int rev = recursive_func(n, 0);

		if (n == rev)
			System.out.println("Palindrome = Yes");
		else
			System.out.println("Palindrome = No");
	}
}
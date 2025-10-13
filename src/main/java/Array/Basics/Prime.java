package Array.Basics;

//A number that is divisible by only 1 and itself.
//0 and 1 are not prime numbers. The 2 is the only even prime number because all the other even numbers can be divided by 2.

public class Prime {	//prime no's up to n
   public static void main (String[] args) {
	   StringBuilder sb = new StringBuilder();
	  for(int i = 2; i <= 100; i++) {
		  boolean flag = true;  // int counter=0;
		  for(int j = 2; j < i; j++) {
			  if(i%j==0) {
				  flag = false;		// counter++;
				  break;
			  }
		  }
		  if(flag)	// if(counter == 0)
			  sb.append(i).append(",");
	  }

	   // Remove the last comma
	   if (sb.length() > 0)
		   sb.setLength(sb.length() - 1);  // better than regex
	   //System.out.print(str.replaceAll(",$","")); // $ indicates end of string. so it replaces last , only.
   }
}


/*
//to check given no. is prime or not
	
boolean isPrime(int n){
	if(n<=1)
		return false;
	for(int i=2; i <= Math.sqrt(n); i++) {  // If n has any factor other than 1 and n, one of them must be ≤ √n.
	   if(n%i==0)
		 return false;
	}
	return true;
}

//Explanation:
If n is not prime, it can be factored as: n = a × b

Now observe:
If both a and b were greater than √n, then:
a > √n and b > √n
⇒ a × b > √n × √n = n ❌ Contradiction! (n can't be greater than itself)

So at least one of the factors must be ≤ √n. That's what we are checking.
*/

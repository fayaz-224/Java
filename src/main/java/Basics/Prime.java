package Basics;

//A number that is divisible by only 1 and itself.
//0 and 1 are not prime numbers. The 2 is the only even prime number because all the other even numbers can be divided by 2.
public class Prime	//prime no's up to n
{
   public static void main (String[] args) {
	  String str=""; 
	  for(int i = 2; i <= 100; i++) { //n=100
		  boolean flag = true;
		  for(int j = 2; j < i; j++) {
			  if(i%j==0) {
				  flag = false;
				  break;
			  }
		  }
		  if(flag)
		     str += i+",";
	  }
	  System.out.print(str.replaceAll(",$","")); // $ indicates end of string.so it replaces last , only.
	   
		
//       for (int i = 2; i <= 100; i++){ 	  
//    	    int counter=0;
//          for(int j=1; j<=i; j++){
//             if(i%j==0)
//            	 counter = counter + 1;
//          }
//          if(counter == 2)
//        	// System.out.print(i+",");	if we use this we cant remove last space or , So use a string.
//            str=str+i+",";
//       }
//       System.out.print(str.replaceAll(",$",""));
  
   }
}



/*
to check given no. is prime or not
	
boolean isPrime(int n){
	if(n<=1)
		return false;
	for(int i=2; i<=n/2; i++) {  //1 and n(itself) are factors. so, we have to check if any other num divides it.
	   if(n%i==0)
		 return false;
	}
	return true;
}
*/

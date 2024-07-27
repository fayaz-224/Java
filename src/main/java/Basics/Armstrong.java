package Basics;

/* if the sum of its own digits, raised to a power of digits(length of number) results in the number itself
3: 3^1 = 3
153: 1^3 + 5^3 + 3^3 = 1 + 125+ 27 = 153
1634: 1^4 + 6^4 + 3^4 + 4^4 = 1 + 1296 + 81 + 256 = 1643
*/
class Armstrong {
  public static void main(String[] args) {  
    int sum=0, k, digits=0;
    int n=9474;
    
    int temp = n;
    while(temp>0) {    // to count the len of number
    	temp = temp/10;
    	digits++;   
    }  

    while(n>0) {  
    	k = n%10;
    	sum = sum + (int)(Math.pow(k,digits)); //OP is double, So convert to int
    	n = n/10;
    }

    if(temp==sum)
    	System.out.println("armstrong number");
    else
        System.out.println("Not armstrong number");
   }  
} 
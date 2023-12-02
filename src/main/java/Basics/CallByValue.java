package Basics;
//In java only call by value exists

class CallByValue
{  
 int x=50;  
  
 	void change(int x)
 	{  
 		x=x+100; //changes will be in the local variable only  
 		System.out.println(x);  
 	}  
     
 	public static void main(String args[])
 	{  
 		CallByValue op=new CallByValue(); 
	
 		System.out.println("before change "+op.x);  
 		op.change(50);  
 		System.out.println("after change "+op.x);  //we get o/p as 50 only.
  
 	}  
}  
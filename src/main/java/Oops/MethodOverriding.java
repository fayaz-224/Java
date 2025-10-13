package Oops;

//If a subclass provides the specific implementation of the method that has been declared by one of its parent class,
//it is known as method overriding -----Runtime polymorphism
class Bank {
	int getRateOfInterest(){return 0;}  
}
	 
	class SBI extends Bank{
		int testMethod(){return 1000;}  // we cannot access subclass-specific methods after upcasting.
		int getRateOfInterest(){return 8;}
	}  
	class ICICI extends Bank{  
		int getRateOfInterest(){return 7;}
	}  
	class AXIS extends Bank{  
		int getRateOfInterest(){return 9;}
	}

class MethodOverriding {
	public static void main(String args[]) {
		Bank s = new SBI();  //upcasting --> reference variable of Parent class refers to the object of Child class
		ICICI i = new ICICI();
		AXIS a = new AXIS();
		System.out.println("SBI Rate of Interest: " + s.getRateOfInterest());
		System.out.println("ICICI Rate of Interest: " + i.getRateOfInterest());
		System.out.println("AXIS Rate of Interest: " + a.getRateOfInterest());

		//System.out.println("SBI specific method run: " + s.testMethod());
	}
}

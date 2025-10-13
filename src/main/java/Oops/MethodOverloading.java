package Oops;

// If a class has multiple methods having same name with different parameters or different type with same parameters,
//it is known as Method Overloading ----compile time polymorphism.
public class MethodOverloading {

	int add(int a,int b)
	{
		return a+b;
	}  
	double add(double a,double b)
	{
		return a+b;
	}  
	int add(int a,int b,int c)
	{
		return a+b+c;
	}  
		  
	public static void main(String[] args){  
		MethodOverloading m= new MethodOverloading();
		System.out.println(m.add(11,11));
		System.out.println(m.add(5.55,7.65));
		System.out.println(m.add(11,11,11));
	}
}  

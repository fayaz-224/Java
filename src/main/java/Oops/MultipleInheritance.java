package Oops;

//Multiple inheritance is not supported through class in java, but it is possible by an interface
interface Printable{  
	void print();
}  

interface Showable{  
	void print();
}  
  
class MultipleInterface implements Printable, Showable {

	public void print(){
		System.out.println("Hello");
	}

	public static void main(String args[]){  
		MultipleInterface obj = new MultipleInterface();  
		obj.print();  
	}  
}  
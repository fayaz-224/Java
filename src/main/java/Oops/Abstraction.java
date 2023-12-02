package Oops;

// contains abstract & non-abstract methods
 abstract class Bike{  
	 
   abstract void run();  
   
   void changeGear(){
	   System.out.println("gear changed");
   }  
 }  
 
 class Honda extends Bike{  //implimenting abstract method, othrewise we need to make this class abstarct
	 void run(){System.out.println("running safely..");}  
 }  
  
 class Abstraction {  
 public static void main(String args[]){  
	 Bike obj = new Honda();  //upcasting
	 obj.run();  
	 obj.changeGear();  
 }  
}  
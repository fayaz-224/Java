package JavaConcepts.Oops;

//Abstraction is a process of hiding the implementation details and showing only functionality to the user.
// contains abstract & non-abstract methods
abstract class Bike{
    abstract void run();
    void changeGear(){
       System.out.println("gear changed");
    }
}

class Honda extends Bike{  //implement abstract method, otherwise we need to make this class abstract
    void run(){System.out.println("running safely..");}
}

class Abstraction {
    public static void main(String args[]){
         Bike obj = new Honda();  //upcasting
         obj.run();
         obj.changeGear();
    }
}  
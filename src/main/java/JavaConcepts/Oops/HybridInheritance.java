package JavaConcepts.Oops;

//the hybrid inheritance is the combination of two or more types of inheritance.
//here we are seeing a version of hybrid inheritance of Single and Multiple Inheritances.
class ClassA {
    public void displayA()
    {
        System.out.println("display() method of ClassA");
    }
}

interface InterfaceB {
    void show();
}

interface InterfaceC {
    void show();
}

class HybridInheritance extends ClassA implements InterfaceB, InterfaceC { //Single and Multiple Inheritance
    public void show() {
        System.out.println("show() method implementation");
    }
    public void displayD() {
        System.out.println("display() method of HybridInheritance");
    }
    public static void main(String args[]) {
    	HybridInheritance  d = new HybridInheritance ();
        d.displayD();
        d.show();
        d.displayA();
    }
}
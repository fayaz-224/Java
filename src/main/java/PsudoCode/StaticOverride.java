package PsudoCode;

//static methods in interfaces cannot be overridden in Java.
class Base {
    public static void display() {
        System.out.println("Static method from Base");
    }
    public void print() {
        System.out.println("Non-static or Instance method from Base");
    }
}

class Derived extends Base {
    public static void display() {  // This method is hidden by display() in Base
        System.out.println("Static method from subclass");
    }
    public void print() {    // This method overrides print() in Base
        System.out.println("Non-static or Instance method from subclass");
    }
}


class StaticOverride {
    public static void main(String args[ ]) {
        //display() will be invoked based on the reference type Base class
        Base obj1 = new Derived();
        obj1.display(); //calls base method
        obj1.print();  //calls subclass method

        //display() will be invoked based on the object type of Derived class
        Derived obj2 = new Derived();
        obj2.display(); //calls subclass method
        obj2.print();  //calls subclass method
    }
}



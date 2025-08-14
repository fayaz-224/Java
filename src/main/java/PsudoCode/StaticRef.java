package PsudoCode;


class Parent{
    public static void print(){  //static method
        System.out.println("I am Parent");
    }
}

public class StaticRef {

    public static void main(String args[]) {
        Parent parent = null;
        //print method in the Parent class is a static method. This means it belongs to the class itself rather than any instance of the class.
        // Therefore, it can be called using the class name or any reference to the class, even if that reference is null.
        parent.print();
    }
}
//op: I am Parent
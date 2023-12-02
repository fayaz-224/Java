package Oops;

//the hybrid inheritance is the composition of two or more types of inheritance. It is also acheived through Interfaces only.
class ClassA 
{
    public void dispA()
    {
        System.out.println("disp() method of ClassA");
    }
}

interface InterfaceB 
{
    void show();
}

interface InterfaceC 
{
    void show();
}

class HybridInheritance extends ClassA implements InterfaceB, InterfaceC //Single and Multiple Inheritance
{
    public void show()
    {
        System.out.println("show() method implementation");
    }
    public void dispD()
    {
        System.out.println("disp() method of ClassD");
    }
    public static void main(String args[])
    {
    	HybridInheritance  d = new HybridInheritance ();
        d.dispD();
        d.show();
        d.dispA();
    }
}
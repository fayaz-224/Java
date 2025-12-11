package JavaConcepts.Oops;

// contains only abstract methods ie, no method body
interface Drawable{  
	
    int a = 10; // by default public, static and final
    void draw();  
    default void show()
    {
        System.out.println("Default method");
    }
}  
  
class Rectangle implements Drawable{  
    public void draw(){
        System.out.println("drawing rectangle");}
}  

class Circle implements Drawable{  
    public void draw(){
        System.out.println("drawing circle");}
}  
 
class Interface {  
    public static void main(String args[]){
        Drawable d=new Circle();
        d.draw();
        d.show();
    }
}  
package JavaConcepts.Oops;

// Abstraction
abstract class Shape {
    abstract double area();
}

// Inheritance & Polymorphism
class Circle1 extends Shape {
    private double radius;
    public Circle1(double radius) {
        this.radius = radius;
    }
    @Override
    double area() {     //Overriding
        return Math.PI * radius * radius;
    } //Overriding
}

class Rectangle1 extends Shape {
    private double length;
    private double width;
    public Rectangle1(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    double area() {
        return length * width;
    }
}

// Encapsulation
class Printer {
    void printShapeDetails(Shape shape) {
        System.out.println("Area: " + shape.area());
    }
}

public class AllInOne {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Circle1 circle = new Circle1(5);  // Static binding
        Shape rectangle = new Rectangle1(4, 6);  // Dynamic binding

        System.out.println("Circle details:");
        printer.printShapeDetails(circle);
        System.out.println("Rectangle details:");
        printer.printShapeDetails(rectangle);
    }
}


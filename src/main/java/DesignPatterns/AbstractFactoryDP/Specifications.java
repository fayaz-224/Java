package DesignPatterns.AbstractFactoryDP;

// Abstract Product Interface for Car Specifications
public interface Specifications {
    void display(); //we can return data as well if needed
}


// Concrete Product for North America Car Specification
class NorthAmericaSpecification implements Specifications {
    public void display() {
        System.out.println("North America Car Specification: Safety features compliant with local regulations.");
    }
}
// Concrete Product for Europe Car Specification
class EuropeSpecification implements Specifications {
    public void display() {
        System.out.println("Europe Car Specification: Fuel efficiency and emissions compliant with EU standards.");
    }
}
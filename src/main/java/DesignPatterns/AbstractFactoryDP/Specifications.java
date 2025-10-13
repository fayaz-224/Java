package DesignPatterns.AbstractFactoryDP;

// Abstract Product Interface for Car Specifications
public interface Specifications {
    String getSpec();
}


// Concrete Product for North America Car Specification
class NorthAmericaSpecification implements Specifications {
    public String getSpec() {
        return "Safety features compliant with local regulations.";
    }
}
// Concrete Product for Europe Car Specification
class EuropeSpecification implements Specifications {
    public String getSpec() {
        return "Fuel efficiency and emissions compliant with EU standards.";
    }
}
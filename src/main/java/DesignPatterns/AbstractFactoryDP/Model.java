package DesignPatterns.AbstractFactoryDP;

// Abstract Product Interface for Cars
public interface Model {
    String getModel();
}


// Concrete Product for Sedan Car
class Sedan implements Model {
    public String getModel() {
        return "SEDAN";
    }
}
// Concrete Product for Hatchback Car
class Hatchback implements Model {
    public String getModel() {
        return "Hatchback";
    }
}
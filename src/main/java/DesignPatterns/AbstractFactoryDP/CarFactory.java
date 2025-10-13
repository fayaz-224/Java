package DesignPatterns.AbstractFactoryDP;

// Abstract Factory Interface
public interface CarFactory {
    Model getCar(String name);
    Specifications getSpecification();
}


// Concrete Factory for North America Cars
class NorthAmericaCarFactory implements CarFactory {
    public Model getCar(String modelName) {
        if (modelName.equalsIgnoreCase("SEDAN")) {
            return new Sedan();
        } else if (modelName.equalsIgnoreCase("HATCHBACK")) {
            return new Hatchback();
        }
        return null;
    }

    public Specifications getSpecification() {
        return new NorthAmericaSpecification();
    }
}

// Concrete Factory for Europe Cars
class EuropeCarFactory implements CarFactory {
    public Model getCar(String modelName) {
        if (modelName.equalsIgnoreCase("SEDAN")) {
            return new Sedan();
        } else if (modelName.equalsIgnoreCase("HATCHBACK")) {
            return new Hatchback();
        }
        return null;
    }

    public Specifications getSpecification() {
        return new EuropeSpecification();
    }
}
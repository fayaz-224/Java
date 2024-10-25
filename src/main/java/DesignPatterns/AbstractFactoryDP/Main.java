package DesignPatterns.AbstractFactoryDP;

//Abstract Factory pattern is almost similar to Factory Pattern except, its like factory of factories.
//Abstract Factory lets a class returns a factory of classes. So, this is the reason that Abstract Factory Pattern is one level higher than the Factory Pattern.

class Main {
    public static void main(String[] args) {
        // Creating cars for North America
        CarFactory northAmericaFactory = new NorthAmericaCarFactory();

        Model americaCar = northAmericaFactory.getCar("Sedan");
        Specifications americaSpec = northAmericaFactory.getSpecification();
        System.out.println(americaCar.getModel());
        americaSpec.display();


        // Creating cars for Europe
        CarFactory europeFactory = new EuropeCarFactory();

        Model europeCar = europeFactory.getCar("Hatchback");
        Specifications europeSpec = europeFactory.getSpecification();
        System.out.println(europeCar.getModel());
        europeSpec.display();
    }
}


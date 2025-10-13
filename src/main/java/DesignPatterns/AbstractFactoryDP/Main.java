package DesignPatterns.AbstractFactoryDP;

//Abstract Factory pattern is almost similar to Factory Pattern except, its like factory of factories.
//Abstract Factory lets a class returns a factory of classes. So, this is the reason that Abstract Factory Pattern is one level higher than the Factory Pattern.
class Main {
    public static void main(String[] args) {
        // Creating cars for North America
        CarFactory northAmericaFactory = new NorthAmericaCarFactory();
        Model naCar = northAmericaFactory.getCar("Sedan");
        Specifications naSpec = northAmericaFactory.getSpecification();
        System.out.println(naCar.getModel() +" -> "+ naSpec.getSpec());


        // Creating cars for Europe
        CarFactory europeFactory = new EuropeCarFactory();
        Model europeCar = europeFactory.getCar("Hatchback");
        Specifications europeSpec = europeFactory.getSpecification();
        System.out.println(europeCar.getModel() +" -> "+ europeSpec.getSpec());
    }
}

/*
If you are familiar with factory design pattern in java, you will notice that we have a single Factory class.
This factory class returns different subclasses based on the input provided and factory class uses if-else or switch statement to achieve this.
In the Abstract Factory pattern, we get rid of if-else block and have a factory class for each sub-class.
Then an Abstract Factory class that will return the sub-class based on the input factory class.
 */
package Collections;

import java.util.ArrayList;
import java.util.List;

//In Arrays, we can store Homogeneous data only. But in Collections, we can store heterogeneous data
public class CollectionsDemo {
    public static void main(String[] args) {

        List<Object> heterogeneousList = new ArrayList<>(); //object type

        heterogeneousList.add("Hello");           // String
        heterogeneousList.add(123);               // Integer
        heterogeneousList.add(3.14);              // Double
        heterogeneousList.add(true);              // Boolean
        heterogeneousList.add(new Car("Toyota", "Camry"));   // custom object

        for (Object obj : heterogeneousList) {
            System.out.println(obj);  // Calls obj.toString() implicitly
        }
    }
}

// Example of custom class
class Car {
    private String make;
    private String model;
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
    @Override
    public String toString() {  //if we dont override toString(), we get obj like MyClass@1a2b3c4d
        return "Car{make='" + make + "', model='" + model + "'}";
    }
}

package Collections;

import java.util.ArrayList;
import java.util.List;

//In Arrays, we can store Homogeneous data elements only. In Collections, we can store heterogeneous data
public class CollectionsDemo {
    public static void main(String[] args) {

        List<Object> heterogeneousList = new ArrayList<>(); //object type

        heterogeneousList.add("Hello");           // String
        heterogeneousList.add(123);               // Integer
        heterogeneousList.add(3.14);              // Double
        heterogeneousList.add(true);              // Boolean
        heterogeneousList.add(new Emp("Alice", 50000)); // Employee object
        heterogeneousList.add(new Car("Toyota", "Camry"));   // Car object

        for (Object obj : heterogeneousList) {
            System.out.println(obj);
        }
    }
}

// Example of custom classes
class Emp {
    private String name;
    private double salary;
    public Emp(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + '}';
    }
}

class Car {
    private String make;
    private String model;
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
    @Override
    public String toString() {
        return "Car{make='" + make + "', model='" + model + "'}";
    }
}

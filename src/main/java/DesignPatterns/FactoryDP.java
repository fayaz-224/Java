package DesignPatterns;

//The Factory DP is used when we have a superclass with multiple sub-classes and based on input, we need to return one of the sub-class.
//Factory pattern provides abstraction between implementation and client classes through inheritance - Loose coupling.

//Super class in factory design pattern can be an interface, abstract class or a normal java class
interface Employee {
    int getSalary();
}


class AndroidDeveloper implements Employee {
    @Override
    public int getSalary() {
        return 50000;
    }
}
class WebDeveloper implements Employee {
    @Override
    public int getSalary() {
        return 25000;
    }
}


class FactoryDP {  //Factory class - to achieve loose coupling (client doesn't know about classes)

    public static Employee getEmployee(String empType) {
        if (empType.equalsIgnoreCase("ANDROID")) {
            return new AndroidDeveloper();
        } else if (empType.equalsIgnoreCase("WEB")) {
            return new WebDeveloper();
        }
        return null;
    }
}

package DesignPatterns;
// The Factory design pattern defines an interface or abstract class for creating objects, but the specific classes are instantiated by the factory method based on certain conditions or parameters.
//It decouples the client code from the actual implementations of the products, making it easier to extend the product family and maintain the code.
public interface Employee {
    int getSalary();
}

class AndroidDeveloper implements  Employee {

    @Override
    public int getSalary() {
        System.out.println("AndroidDeveloper salary: ");
        return 25000;
    }
}

class WebDeveloper implements  Employee {

    @Override
    public int getSalary() {
        System.out.println("WebDeveloper salary: ");
        return 15000;
    }
}

class FactoryDP {

    // get the employee
    public static Employee getEmployee(String empType) {
        if (empType.equalsIgnoreCase("ANDROIDDEVELOPER")) {
            return new AndroidDeveloper();
        } else if (empType.equalsIgnoreCase("WEBDEVELOPER")) {
            return new WebDeveloper();
        } else {
            return null;
        }
    }
}
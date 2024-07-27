package DesignPatterns;

// The Factory design pattern defines an interface or abstract class for creating objects, but the specific classes are instantiated by the factory method based on certain conditions or parameters.
// It encapsulates object creation logic in a separate method, promoting loose coupling between the creator and the created objects.
// This pattern is particularly useful when the exact types of objects to be created may vary or need to be determined at runtime, enabling flexibility and extensibility in object creation.
interface Employee {
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
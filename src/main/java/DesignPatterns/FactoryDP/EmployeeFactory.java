package DesignPatterns.FactoryDP;


// The Factory design pattern defines an interface or abstract class for creating objects, but the specific classes are instantiated by the factory method based on certain conditions or parameters.
// It encapsulates object creation logic in a separate method, promoting loose coupling between the creator and the created objects.
// This pattern is particularly useful when the exact types of objects to be created may vary or need to be determined at runtime, enabling flexibility and extensibility in object creation.

class EmployeeFactory {

    public static Employee getEmployee(String empType) {
        if (empType.equalsIgnoreCase("ANDROID")) {  //we can use switch too
            return new AndroidDeveloper();
        } else if (empType.equalsIgnoreCase("WEB")) {
            return new WebDeveloper();
        }
        return null;
    }
}
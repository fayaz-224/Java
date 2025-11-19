package Oops;

import java.util.ArrayList;

//Declare class as final.
//Make all properties as private final.
//Declare all args constructor.
//Do not declare setters, Only getters.
//If there are custom ref objects in the class as properties, implement clone (Defensive copy).
//If there are other types of nested objects as properties, perform a deep copy.

final class ImmutableClass {
    private final String empName; //normal field
    //private final Address address; //custom ref obj
    private final ArrayList<String> phoneNumbers;  //other nested or ref obj (mutable objects)

    public ImmutableClass(String name, ArrayList<String> phoneNumbers) {
        this.empName = name;
        //this.address = (Address) address.clone(); // Defensive copy
        this.phoneNumbers = new ArrayList<>(phoneNumbers); // Defensive copy

    }

    public String getEmpName() { return empName;}

    // impl clone() inside address class
//    public Address getAddress() throws CloneNotSupportedException {
//        return (Address) address.clone(); // Defensive copy
//    }

    // deep copy the list of phone numbers - It will always return initialized objects
    public ArrayList<String> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers); // Defensive copy
    }
}


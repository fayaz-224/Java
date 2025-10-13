package Oops;

import java.util.ArrayList;

//Declare class as final.
//Make all properties as private final.
//Do not declare setters, Only getters.
//Declare all args constructor.
//If there are custom ref objects in the class as properties, implement clone.
//If there are other types of nested objects as properties, perform a deep copy.

final class ImmutableClass {
    private final String empName; //normal field
    //private final Address address; //custom ref obj
    private final ArrayList<String> phoneNumbers;  //other nested or ref obj (mutable objects)

    public ImmutableClass(String name, ArrayList<String> phoneNumbers) {
        this.empName = name;
        //this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmpName() { return empName;}

    // clone the address object – impl clone() inside address class
//    public Address getAddress() throws CloneNotSupportedException {
//        return (Address) address.clone();
//    }

    // deep copy the list of phone numbers - It will always return initialized objects
    public ArrayList<String> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers);
    }
}


package Collections;

import java.util.HashSet;
import java.util.Objects;

//if we override equals() method, we must override hashcode(). Others we might face improper functionality
class Employee {

    String name;
    int age;
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof Employee)) // Check if obj is not an instance of Employee
            return false;

        Employee employee = (Employee) obj; // Cast obj to Employee

        return employee.getAge() == this.getAge()
                && employee.getName().equals(this.getName()); // Compare age and name
    }

    @Override
    public int hashCode() { //custom hashing
        return Objects.hash(name, age);
    }
}


public class OverrideHashCode {
    public static void main(String[] args) {

        Employee emp = new Employee("rajeev", 24);
        Employee emp1 = new Employee("yash", 25);
        Employee emp2 = new Employee("rajeev", 24);

        HashSet<Employee> employees = new HashSet<Employee>();
        employees.add(emp);
        employees.add(emp1);
        employees.add(emp2);

        System.out.println("employee.hashCode():  " + emp.hashCode() + "\n" +
                "  employee1.hashCode():" + emp1.hashCode() + "\n" +
                "  employee2.hashCode():" + emp2.hashCode());

        //since emp and emp2 are same, equals() method override its previous value
        employees.forEach(e -> System.out.println(e.getName() + "-" + e.getAge()));
    }
}

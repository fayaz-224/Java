package Collections;

import java.util.HashSet;

public class OverrideHashCode {
    public static void main(String[] args) {

        Employee emp = new Employee("Alice", 23, "Computer Science",50000);
        Employee emp1 = new Employee("Jack", 44, "Social Science", 75000);
        Employee emp2 = new Employee("Alice", 23, "Computer Science",38000);

        HashSet<Employee> employees = new HashSet<Employee>();
        employees.add(emp);
        employees.add(emp1);
        employees.add(emp2);

        System.out.println("employee.hashCode():  " + emp.hashCode() + "\n" +
                "employee1.hashCode(): " + emp1.hashCode() + "\n" +
                "employee2.hashCode(): " + emp2.hashCode());

        //since emp and emp2 are same, equals() method override its previous value
        employees.forEach(e -> System.out.println(e.getName() +","+ e.getAge() +","+ e.getDept() +","+ e.getSalary()));
    }
}

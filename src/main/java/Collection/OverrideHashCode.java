package Collection;

import java.util.HashMap;
import java.util.Map;

public class OverrideHashCode {
    public static void main(String[] args) {

        Employee emp = new Employee("Alice", 23, "Computer Science",50000);
        Employee emp1 = new Employee("Jack", 44, "Social Science", 75000);
        Employee emp2 = new Employee("Alice", 23, "Computer Science",38000);

        Map<Employee, Employee> employees = new HashMap<>();
        employees.put(emp, emp);
        employees.put(emp1, emp1);
        employees.put(emp2, emp2);

        System.out.println("employee.hashCode():  " + emp.hashCode() + "\n" +
                "employee1.hashCode(): " + emp1.hashCode() + "\n" +
                "employee2.hashCode(): " + emp2.hashCode());

        //since emp and emp2 are same, equals() method override its previous value
        for(Map.Entry<Employee, Employee> e: employees.entrySet()){
            System.out.println(e.getKey() +" - "+ e.getValue().name +","+ e.getValue().age +","+ e.getValue().dept +","+ e.getValue().salary);
        }
    }
}

package Collections;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StreamsImpl {
    public static void main(String[] args) {

        List<Employee1> employees = List.of(
                new Employee1("Alice", 50000),
                new Employee1("Bob", 60000),
                new Employee1("Charlie", 45000),
                new Employee1("Jack", 75000)
        );

        // Sort employees based on their salaries in descending order
        List<Employee1> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingInt(Employee1::getSalary).reversed())   //use .sorted(Comparator.reverseOrder() for non-objects
                .collect(Collectors.toList());
        sortedEmployees.forEach(System.out::println);

        //fetch top 2 employees only in desc order
        List<Employee1> sortedEmployees1 = employees.stream()
                .sorted(Comparator.comparingInt(Employee1::getSalary).reversed())   //use .sorted(Comparator.reverseOrder() for non-objects
                .limit(2)
                .toList();
        sortedEmployees1.forEach(System.out::println);

        //fetch all employees having salary less than 2nd highest salary
        List<Employee1> sortedEmployees2 = employees.stream()
                .sorted(Comparator.comparingInt(Employee1::getSalary).reversed())
                .skip(2)
                .toList();
        sortedEmployees2.forEach(System.out::println);
    }
}

class Employee1 {
    private String name;
    private int salary;

    public Employee1(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}


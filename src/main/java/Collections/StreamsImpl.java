package Collections;

import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsImpl {
    public static void main(String[] args) {

        List<Employee1> employees = List.of(
                new Employee1("Alice", "Computer Science",50000),
                new Employee1("Bob", "Mechanical Engineering", 60000),
                new Employee1("Charlie", "Mechanical Engineering", 45000),
                new Employee1("Jack", "Computer Science", 75000)
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
                .collect(Collectors.toList());
        sortedEmployees1.forEach(System.out::println);

        //fetch all employees having salary less than 2nd highest salary
        List<Employee1> sortedEmployees2 = employees.stream()
                .sorted(Comparator.comparingInt(Employee1::getSalary).reversed())
                .skip(2)
                .collect(Collectors.toList());
        sortedEmployees2.forEach(System.out::println);

        //list of employees in each department
        employees.stream()
                .collect(Collectors.groupingBy(Employee1::getDept))
                .forEach((dept, studentsInDept) -> {
                            System.out.println("Department: " + dept);
                            studentsInDept.forEach(student -> System.out.println("  " + student));
                });
    }
}

class Employee1 {
    private final String name;
    private final int salary;
    private String dept;

    public Employee1(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public String getDept() {return dept;}
    @Override
    public String toString() {
        return "Employee{" +
                "name=" + name + '\'' +
                "Dept=" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}


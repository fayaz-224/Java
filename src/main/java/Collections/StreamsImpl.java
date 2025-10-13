package Collections;

import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsImpl {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Alice", 23, "Computer Science",50000),
                new Employee("Bob", 21, "Mechanical Engineering", 60000),
                new Employee("Charlie", 43, "Mechanical Engineering", 45000),
                new Employee("Jack", 44, "Computer Science", 75000)
        );

        // Sort employees based on their salaries in descending order
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())   //use .sorted(Comparator.reverseOrder() for non-objects
                .collect(Collectors.toList());
        sortedEmployees.forEach(System.out::println);

        //fetch top 2 employees only based on salary in desc order
        List<Employee> sortedEmployees1 = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())   //use .sorted(Comparator.reverseOrder() for non-objects
                .limit(2)
                .collect(Collectors.toList());
        sortedEmployees1.forEach(System.out::println);

        //fetch all employees having salary less than 2nd highest salary
        List<Employee> sortedEmployees2 = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .skip(2)
                .collect(Collectors.toList());
        sortedEmployees2.forEach(System.out::println);

        //list of employees in each department
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept))
                .forEach((dept, studentsInDept) -> {
                            System.out.println("Department: " + dept);
                            studentsInDept.forEach(student -> System.out.println("  " + student));
                });

        //collect salary greater than 55000
        employees.stream()
                .filter(e -> e.getSalary() > 55000)
                .forEach(res -> System.out.println("filtered: "+res));
    }
}

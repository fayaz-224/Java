package Collections;

import java.util.Objects;

//if we override equals() method, we must override hashcode(). Others we might face improper functionality
class Employee {
    String name;
    int age;
    int salary;
    String dept;

    public Employee(String name, int age, String dept, int salary) {
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getSalary() {return salary;}
    public String getDept() {return dept;}
    public void setSalary(int salary) {this.salary = salary;}
    public void setDept(String dept) {this.dept = dept;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) && Objects.equals(dept, employee.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dept, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}

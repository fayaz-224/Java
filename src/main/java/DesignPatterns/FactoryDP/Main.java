package DesignPatterns.FactoryDP;

public class Main {
    public static void main(String args[]) {
        //Factory
        Employee emp1 = EmployeeFactory.getEmployee("Web");
        Employee emp2 = EmployeeFactory.getEmployee("Android");
        System.out.println("Android Developer salary: "+ emp1.getSalary());
        System.out.println("Web Developer salary: "+ emp2.getSalary());
    }
}

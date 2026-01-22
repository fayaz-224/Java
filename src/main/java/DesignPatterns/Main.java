package DesignPatterns;

// Creational design patterns
class Main {
    public static void main(String args[]) throws CloneNotSupportedException {
        //singleton
        SingletonDP obj1 = SingletonDP.getInstance();
        SingletonDP obj2 = SingletonDP.getInstance();
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        //Prototype
        PrototypeDP p1 = new PrototypeDP(1, "flash");
        PrototypeDP p2 = (PrototypeDP) p1.clone();
        System.out.println(p1);
        System.out.println(p2);

        //builder
        BuilderDP dog1 = new BuilderDP.DogBuilder("Bruno", "Pug").setAge(4).setColor("black").build();
        BuilderDP dog2 = new BuilderDP.DogBuilder("Alissa", "Doberman").build();
        System.out.println(dog1.getAge());
        System.out.println(dog2.getAge());

        //Factory
        Employee emp1 = FactoryDP.getEmployee("Web");
        Employee emp2 = FactoryDP.getEmployee("Android");
        System.out.println("Web Developer salary: "+ emp1.getSalary());
        System.out.println("Android Developer salary: "+ emp2.getSalary());
    }
}

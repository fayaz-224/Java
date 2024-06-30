package DesignPatterns;

// Creational design patterns
class Main {
    public static void main(String args[]) throws CloneNotSupportedException {
        //singleton
        SingletonDP obj1 = SingletonDP.getSingletonObj();
        SingletonDP obj2 = SingletonDP.getSingletonObj();
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        //builder
        BuilderDP dog1 = new BuilderDP.DogBuilder().setName("Bruno").setBreed ("Pug").setAge(4).setColor("black").build();
        BuilderDP dog2 = new BuilderDP.DogBuilder().setName("Alissa").setAge(1).build();
        System.out.println(dog1);
        System.out.println(dog2);

        //Factory
        Employee emp1 = FactoryDP.getEmployee("WebDeveloper");
        Employee emp2 = FactoryDP.getEmployee("AndroidDeveloper");
        System.out.println(emp1.getSalary());
        System.out.println(emp2.getSalary());

        //Prototype
        PrototypeDP p1 = new PrototypeDP(1, "flash");
        System.out.println(p1);
        PrototypeDP p2 = (PrototypeDP) p1.clone();
        System.out.println(p2);
    }
}

package DesignPatterns;

//The Builder design pattern used in software design to construct a complex object step by step.
// It separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
//Use the Builder Pattern when:
//  An object has many optional parameters.
//  You want to avoid telescoping constructors (having multiple constructors for each combination of fields).
//  You need immutable objects.
//  You want readable and maintainable object creation.
public class BuilderDP {
    private String name;
    private String breed;
    private int age;
    private String color;

    // Private constructor: only Builder can access
    private BuilderDP(DogBuilder builder) {
        this.name = builder.name;  //if you want to use getters in DogBuilder class then we can also use builder.getName();
        this.breed = builder.breed;
        this.age = builder.age;
        this.color = builder.color;
    }

    // setters are exposed not to clients
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }
    public int getAge() {
        return age;
    }
    public String getColor() {
        return color;
    }

    // Inner class - Static builder class for BuilderDP
    public static class DogBuilder {
        private String name;
        private String breed;
        private int age;
        private String color;

        public DogBuilder (String name, String breed) { // required fields
            this.name = name;
            this.breed = breed;
        }

        // Setter methods for optional fields
        public DogBuilder setAge(int age) {
            this.age = age;
            return this;
        }
        public DogBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        // Build method to create BuilderDP object
        public BuilderDP build() {
            return new BuilderDP(this);
        }
    }
}


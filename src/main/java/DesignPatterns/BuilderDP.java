package DesignPatterns;

//The Builder design pattern used in software design to construct a complex object step by step.
// It separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
// It's useful when you need to create objects with many optional parameters or with different configurations.
public class BuilderDP {
    private String name;
    private String breed;
    private int age;
    private String color;

    public BuilderDP(DogBuilder builder) {
        this.name = builder.getName();
        this.breed = builder.getBreed();
        this.age = builder.getAge();
        this.color = builder.getColor();
    }

    // No setters are exposed to clients (or) we can also make setters as private
    public String getBreed() {
        return breed;
    }
    public int getAge() {
        return age;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "name:" + this.name
        + " breed:" + this.breed
        + " age:" + this.age
        + " color:" + this.color;
    }

    // Inner class - Static builder class for BuilderDP
    public static class DogBuilder {
        private String name;
        private String breed;
        private int age;
        private String color;

        // Setter methods for BuilderDP properties returning DogBuilder instance
        public DogBuilder setBreed(String breed) {
            this.breed = breed;
            return this;
        }
        public DogBuilder setAge(int age) {
            this.age = age;
            return this;
        }
        public DogBuilder setColor(String color) {
            this.color = color;
            return this;
        }
        public DogBuilder setName(String name) {
            this.name = name;
            return this;
        }

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

        // Build method to create BuilderDP object
        public BuilderDP build() {
            return new BuilderDP(this);
        }
    }
}


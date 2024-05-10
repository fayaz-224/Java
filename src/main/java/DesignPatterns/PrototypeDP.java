package DesignPatterns;

//The Prototype design pattern is used to create new objects by copying an existing object, known as the prototype.
//This pattern is useful when the cost of creating a new object directly is more expensive or inefficient compared to copying an existing object.
// It helps in reducing the overhead of creating new objects.
public class PrototypeDP implements Cloneable {
    int id;
    String name;

    public PrototypeDP(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PrototypeDP{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

package DesignPatterns;

//The Prototype design pattern is used to create new objects by copying an existing object, known as the prototype.
//This pattern is useful when object creation is a time-consuming and costly operation, compared to copying an existing object.
public class PrototypeDP implements Cloneable {
    private int id;
    private String name;

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
        return super.clone();  //shallow copy, use deep copy if you have mutable fields(map, list etc)

        // Deep copy of mutable list
        // cloned.tags = new ArrayList<>(this.tags);
    }
}

/*
examples:
In Game Development -> Bullets, Enemies, NPCs
Creating thousands of objects per second → cloning is faster than new

Suppose we have an Object that loads data from database. Now we need to modify this data in our program multiple times, so it’s not a good idea to create the Object using new keyword and load all the data again from database.
The better approach would be to clone the existing object into a new object and then do the data manipulation.
 */
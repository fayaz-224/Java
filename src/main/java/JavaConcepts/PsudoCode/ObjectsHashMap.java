package JavaConcepts.PsudoCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Item {
    private String a;
    private String b;
    private String c;

    public Item(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return a.equals(item.a) && b.equals(item.b) && c.equals(item.c);
    }
    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}

public class ObjectsHashMap {
    public static void main(String[] args) {
        Item it1 = new Item("1", "2", "3");
        Item it2 = new Item("1", "2", "3");

        Map<Item, Integer> map = new HashMap<>();
        map.put(it1, 100);
        map.put(it2, 200);  // This will replace the entry of it1 due to identical keys

        // Output: "1" because it1 and it2 are treated as the same key due to overriding equals() and hashCode()
        System.out.println(map.size());
    }
}


/*
However, if Item Class doesn't override equals() and hashCode(),
then it1 and it2 will be treated as different keys (since the default hashCode() implementation from Object class provides distinct hash codes for different objects, and the default equals() checks for object identity).
In that scenario, the size of the HashMap will be 2.
 */
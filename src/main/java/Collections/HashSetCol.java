package Collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetCol {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        System.out.println("size of set is : " + set.size());

        if (set.contains(1)) {
            System.out.println("present");
        }

        if (!set.contains(6)) {
            System.out.println("absent");
        }

        set.remove(1);
        set.add(0);
        System.out.println(set);

        Iterator it = set.iterator();   //iterator
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println();

        if (!set.isEmpty()) {
            System.out.println("set is not empty");
        }
    }
}

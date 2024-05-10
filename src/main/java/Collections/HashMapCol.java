package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapCol {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);
        System.out.println(map);

        map.put("China", 180);
        System.out.println(map);

        //Searching
        if (map.containsKey("Indonesia")) {
            System.out.println("key is present in the map");
        } else {
            System.out.println("key is not present in the map");
        }

        System.out.println(map.get("China")); //key exists, returns its value
        System.out.println(map.get("Indonesia")); //key doesn't exist, returns null

        for (Map.Entry<String, Integer> e : map.entrySet()) { //map iteration - converting map to set
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }

        map.remove("China");
        System.out.println(map);
    }
}

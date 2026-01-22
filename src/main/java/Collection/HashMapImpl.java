package Collection;

import java.util.*;

//Apna college
@SuppressWarnings("unchecked")  //this is generally the preferred way to suppress warnings.
public class HashMapImpl<K, V> {

    private class Node { //K stands for Key, V stands for Value
        K key;
        V value;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;       // number of entries
    private int capacity;      // bucket size
    private LinkedList<Node>[] buckets;

    public HashMapImpl() {
        this.capacity = 4;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Safe hash function
    private int hashFunction(K key) {
        int hash = key.hashCode();  //returns any 32-bit signed int: −2³¹  to  +2³¹−1
        return (hash & Integer.MAX_VALUE) % capacity;  //hash & Integer.MAX_VALUE -> AND operation clears sign bit when done with MAX_VALUE, makes num always +ve
    }

    private Node getNode(K key, int bi) {
        for (Node node : buckets[bi]) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    // ---------------- PUT ----------------
    public void put(K key, V value) {
        int bi = hashFunction(key);  //bucket index
        Node node = getNode(key, bi);  //Node inside LL

        if (node == null) { //key doesn't exist
            buckets[bi].add(new Node(key, value));
            size++;
        } else { //key exist
            node.value = value;
        }

        if ((double) size / capacity > 2.0) {
            rehash();
        }
    }

    // ---------------- GET ----------------
    public V get(K key) {
        int bi = hashFunction(key);
        Node node = getNode(key, bi);
        return node == null ? null : node.value;
    }

    // ---------------- REMOVE ----------------
    public V remove(K key) {
        int bi = hashFunction(key);
        Iterator<Node> it = buckets[bi].iterator();

        while (it.hasNext()) {
            Node node = it.next();
            if (node.key.equals(key)) {
                it.remove();
                size--;
                return node.value;
            }
        }
        return null;
    }

    // ---------------- REHASH ----------------
    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        capacity *= 2;

        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }

        size = 0;
        for (LinkedList<Node> ll : oldBuckets) {
            for (Node node : ll) {
                put(node.key, node.value);
            }
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (LinkedList<Node> ll : buckets) {
            for (Node node : ll) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashMapImpl<String, Integer> map = new HashMapImpl<String, Integer>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);

        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        System.out.println("map Size = " + map.size());

        map.remove("India");
        System.out.println("India removed. India = " + map.get("India"));

        System.out.println("map Size = " + map.size());
    }
}

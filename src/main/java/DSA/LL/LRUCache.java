package DSA.LL;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//LeastRecentlyUsed
//Dequeue and Hashmap gives O(n) TC due to remove() - As below
//Doubly LL and Hashmap give O(1) TC - commented part
public class LRUCache {
    class Node {
        int key;
        int value;
//        Node prev;
//        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int CACHE_SIZE = 3;
    Deque<Node> q = new LinkedList<>();  //Not needed for Doubly LL approach
    Map<Integer, Node> map = new HashMap<>();

//    Node head;
//    Node tail;
//    public LRUCache() {
//        this.head = new Node(0, 0);
//        this.tail = new Node(0, 0);
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public int getFromCache(int key) {
//        if(map.containsKey(key)) {
//            Node node = map.get(key);
//            remove(node);
//            insert(node);
//            return node.value;
//        } else {
//            return -1;
//        }
//    }
//
//    public void putIntoCache(int key, int value) {
//        if(map.containsKey(key)) {
//            remove(map.get(key));
//        }
//        if(map.size() == CACHE_SIZE) {
//            remove(tail.prev);
//        }
//        insert(new Node(key, value));
//    }
//
//    private void remove(Node node) {
//        map.remove(node.key);
//        Node prevNode = node.prev;
//        Node nextNode = node.next;
//        prevNode.next = nextNode;
//        nextNode.prev = prevNode;
//    }
//
//    private void insert(Node newNode){
//        map.put(node.key, newNode);
//        Node nextNode = head.next;
//        head.next = newNode;
//        newNode.prev = head;
//        newNode.next = nextNode;
//        nextNode.prev = newNode;
//    }

    public int getFromCache(int key) {
        if(map.containsKey(key)) {
            Node entry = map.get(key);
            q.remove(entry);  //O(n)
            q.addFirst(entry);
            return entry.value;
        }
        return -1;
    }

    public void putIntoCache(int key, int value) {
        if(map.containsKey(key)) {
            Node entry = map.get(key);
            q.remove(entry);  //O(n)
        } else {
            if(q.size() == CACHE_SIZE) {
                Node entryToBeRemoved = q.removeLast();
                map.remove(entryToBeRemoved.key);
            }
        }

        Node newEntry = new Node(key, value);
        q.addFirst(newEntry);
        map.put(key, newEntry);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();
        cache.putIntoCache(1, 1);
        cache.putIntoCache(2, 2);
        cache.putIntoCache(3, 3);
        System.out.println(cache.getFromCache(1));
        cache.putIntoCache(4, 4);
        System.out.println(cache.getFromCache(2));
        System.out.println(cache.getFromCache(3));
    }
}
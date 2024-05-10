package Collections;
import java.util.LinkedList;

class LinkedListCol {
	public static void main(String[] args) {
        LinkedList<Integer> ar = new LinkedList<>();

        ar.add(10);    //add is by default addLast
		ar.add(20);
		System.out.println(ar);
		
		ar.add(3,300);
		ar.add(40);
        ar.add(5, 300);
		System.out.println(ar);
		System.out.println(ar.size());
		System.out.println(ar.contains(30));
		System.out.println(ar.indexOf(300));
		System.out.println(ar.lastIndexOf(300));
		
		ar.addFirst(100);
		ar.addLast(400);
		System.out.println(ar);
		System.out.println(ar.getFirst());
		System.out.println(ar.getLast());
        System.out.println(ar.isEmpty());
		System.out.println("---------------------");

        LinkedList<Integer> ll = new LinkedList<>();
		ll.add(200);
		ll.add(30);
		ll.add(null);
		ll.add(null);
		System.out.println(ll);
		
		ll.addAll(ar);
		System.out.println(ll);
		System.out.println(ll.containsAll(ar));
		
		ll.addAll(2,ar);
		System.out.println(ll);
		System.out.println(ll.getClass());
		
		ll.push(100);
		System.out.println(ll);		//stack operatons
		
		ll.pop();
		System.out.println(ll);
		
		ll.pop();
		System.out.println(ll);
		
		ll.remove(2);
		System.out.println(ll);

        System.out.println(ll.peek());    //just retreives
        System.out.println(ll.pop());    //retreives and deletes
		System.out.println(ll.peekLast());
		System.out.println(ll.pollLast());
		System.out.println(ll);
		
		System.out.println(ll.clone());
		ll.clear();
		System.out.println(ll);
	}

}

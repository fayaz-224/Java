package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/*
Design a data structure with following features:

1. push an element at the end of the data structure (O(1) time complexity)
2. Pop the element from the beginning of the data structure (pop the earliest element added, O(1) TC)
3. Seek an element at index i at any given state of the data structure. (O(1) TC)

Ex: 1,2,3,4,5
pop() -> 2,3,4,5
pop() -> 3,4,5
Seek(0) -> 3 seek(1)-> 4
 */
class CustomDS{
    Map<Integer,Integer> map = new HashMap<>();
    int startIndex = 0;
    int endIndex = 0;

    public void push(int val){
        map.put(endIndex, val);
        endIndex++;
    }

    public int pop(){
        if (startIndex == endIndex) {
            throw new NoSuchElementException("No elements to pop");
        }
        int value = map.get(startIndex);
        map.remove(startIndex);
        startIndex++;
        return value;
    }

    public int seek(int index){
        int actualIndex = startIndex + index;
        if (!map.containsKey(actualIndex)) {
            throw new NoSuchElementException("Index out of bounds");
        }
        return map.get(actualIndex);
    }


    public static void main(String[] args) {
        CustomDS ds = new CustomDS();

        ds.push(1);
        ds.push(2);
        ds.push(3);
        System.out.println(ds.pop());
        System.out.println(ds.seek(1));
    }
}

package DSA.Stack_Queue;
//A stack is a linear data structure in which the insertion of a new element and removal of an existing element
// takes place at the same end represented as the top of the stack - LIFO

public class StackImpl { //Impl stack using arrays
    static final int MAX = 10;
    int top;
    int[] a = new int[MAX];

    StackImpl() {
        top = -1;
    }

    void push(int x) {
        if (top >= MAX - 1)
            System.out.println("StackImpl Overflow");
        else
            a[++top] = x;
    }

    int pop() {
        if (top < 0) {
            System.out.println("StackImpl Underflow");
            return -1;
        } else {
            return a[top--];
        }
    }

    int peek() {
        if (top < 0) {
            System.out.println("StackImpl Underflow");
            return -1;
        } else {
            return a[top];
        }
    }

    public int size() {
        return top + 1;
    }

    boolean isEmpty() {
        return top < 0;
    }

    void print() {
        System.out.print("Elements present in stack : ");
        for (int i = 0; i <= top; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        StackImpl s = new StackImpl();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println("Popped from stack : " + s.pop());
        System.out.println("Top element is : " + s.peek());
        System.out.println("Is stack empty : " + s.isEmpty());
        System.out.println("StackImpl size: " + s.size());

        s.print();
    }
}


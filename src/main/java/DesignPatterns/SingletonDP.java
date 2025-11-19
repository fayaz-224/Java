package DesignPatterns;

//The Singleton design pattern ensures that a class has only one instance and provides a global point of access to that instance.
// It's useful when exactly one object is needed to coordinate actions across the system, like managing resources or configuration settings.

//lazy way of creating singleton obj
public class SingletonDP {
    private static volatile SingletonDP obj;  //volatile prevents instruction reordering and ensures visibility across threads by avoiding half-constructed objects.

    // Private constructor to prevent instantiation
    private SingletonDP() {
    }

    public static SingletonDP getSingletonObj() {
        if (obj == null) {
            synchronized (SingletonDP.class) {
                if (obj == null) {  //check again, because another thread might have created it when this thread is in between line 15 and 16.
                    obj = new SingletonDP();
                }
            }
        }
        return obj;
    }
}

//Eager way of creating singleton obj
//class SingletonDP {
//    private static SingletonDP obj = new SingletonDP();
//    private Singleton() {}
//
//    public static SingletonDP getSingletonObj() {
//        return obj;
//    }
//}


/*
Common Issues with Singleton in Multithreading:
1. Race Condition During Lazy Initialization
If two threads simultaneously check whether the singleton instance is null, both may proceed to create a new instance, resulting in multiple instances — breaking the Singleton guarantee.

solutions:
1. Eager Initialization  --> Not lazy (may waste resources if the instance is never used)
2. Synchronized method --> Poor performance — every call is synchronized
3. Double-Checked Locking (with volatile)  --> Better performance
 */
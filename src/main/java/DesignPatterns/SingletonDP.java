package DesignPatterns;
//The Singleton design pattern ensures that a class has only one instance and provides a global point of access to that instance.
// It's useful when exactly one object is needed to coordinate actions across the system, like managing resources or configuration settings.

//lazy way of creating singleton obj
public class SingletonDP {
    private static volatile SingletonDP obj;

    // Private constructor to prevent instantiation
    private SingletonDP() {
    }

    public static SingletonDP getSingletonObj() {
        if (obj == null) {
            synchronized (SingletonDP.class) { // Synchronize on class object
                if (obj == null) {
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
//
//    public static SingletonDP getSingletonObj() {
//        return obj;
//    }
//}
package JavaConcepts.Threads;

public class Deadlock {
  public static void main(String[] args) {
    final String resource1 = "ratan jaiswal";  
    final String resource2 = "vimal jaiswal";  
    
    Thread t1 = new Thread(() -> {
        synchronized (resource1) {  //synchronized keyword locks the resource with current thread
            System.out.println("Thread 1: locked resource 1");

            try {
                Thread.sleep(100);  //thread 1 goes to sleep state.so, another thread starts i.e thread 2
            } catch (Exception e) {}

            synchronized (resource2) {
             System.out.println("Thread 1: locked resource 2");  //since resource 2 is already locked by thread 2 it waits for it.
            }
       }
    });
    
    Thread t2 = new Thread(() -> {
      synchronized (resource2) { //thread 2 locks resourse 2
          System.out.println("Thread 2: locked resource 2");

            try {
                Thread.sleep(100);  //thread 2 goes to sleep state.So, above thread 1 continues after 100 ms
            } catch (Exception e) {}

          synchronized (resource1) {
              System.out.println("Thread 2: locked resource 1");
          }
      }
    });
    
    t1.start();  
    t2.start();  
  }  
}  

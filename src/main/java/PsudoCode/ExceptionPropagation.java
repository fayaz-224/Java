package PsudoCode;

//An exception is first thrown from the top of the stack and if it is not caught, it drops down the call stack to the previous method until it gets caught or until it reach the very bottom of the call stack,
//This is called exception propagation and this happens in case of Unchecked Exceptions.
public class ExceptionPropagation {

    void m() {
        int data = 50 / 0; // unchecked exception occurred
        // exception propagated to n()
    }

    void n() {
        m();  // exception propagated to p()
    }

    void p() {
        try {
            n(); // exception handled
        }
        catch (Exception e) {
            System.out.println("Exception handled");
        }
    }

    public static void main(String args[]) {
        ExceptionPropagation obj = new ExceptionPropagation();
        obj.p();
        System.out.println("Normal flow...");
    }
}

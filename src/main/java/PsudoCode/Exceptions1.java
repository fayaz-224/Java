package PsudoCode;

public class Exceptions1 {
    public static void main(String args[]) {
        try {
            int[] array = new int[0];
            boolean[] bool = new boolean[-10];  //runtime exp
            char ch[] = new char[2];
            double dd[] = new double[638729347];  //compile-time exp
        } catch (NegativeArraySizeException e) {
            System.out.println("Error: Attempted to create an array with a negative size.");
        }
        catch (Exception ex) {
            System.out.println("Exception caught: "+ ex);
        }
    }
}


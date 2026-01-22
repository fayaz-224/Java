package JavaConcepts.PsudoCode;

public class Autoboxing {
    //due to a mechanism called "autoboxing," which automatically converts primitive types to their corresponding wrapper classes (such as int to Integer)
    public static void main(String[] arr) {
        Integer num1 = 100;  //within the cached range -127 to 128
        Integer num2 = 100;
        Integer num3 = 500;  //outside the cached range -127 to 128
        Integer num4 = 500;

        if (num1==num2)  //true
            System.out.println("num1 == num2");
        else
            System.out.println("num1 != num2");

        if (num3 == num4)   //false
            System.out.println("num3 == num4");
        else
            System.out.println("num3 != num4");

    //num1 and num2 have the same hash code (indicating the same reference), whereas
    //num3 and num4 have different hash codes (indicating different references).
        System.out.println("num1: " + System.identityHashCode(num1));
        System.out.println("num2: " + System.identityHashCode(num2));
        System.out.println("num3: " + System.identityHashCode(num3));
        System.out.println("num4: " + System.identityHashCode(num4));
    }
}

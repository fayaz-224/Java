package JavaConcepts.PsudoCode;
import java.math.BigInteger;

public class BigInt {
    public static void main(String[] args) {

        BigInteger bi1 = new BigInteger("21789387469");
        BigInteger bi2 = new BigInteger("323503292");

        BigInteger  bi3, bi4, bi5, bi6, bi7;
        bi3 = bi1.add(bi2);
        bi4 = bi1.subtract(bi2);
        bi5 = bi1.multiply(bi2);
        bi6 = bi1.divide(bi2);
        bi7 = bi1.min(bi2);

        System.out.println( bi3);
        System.out.println( bi4);
        System.out.println( bi5);
        System.out.println( bi6);
        System.out.println( bi7);
   }
}
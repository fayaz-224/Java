package PsudoCode;

//check if given no. is power of 2 ex: n=16 => 2^4 => true
public class PowerOf2 {

    public static boolean isPowerOfTwo(int n) {
        // size of int is 4 bytes (32 bits) ie, leave 1bit for sign
        for (int i = 0; i < 31; i++) {
            int ans = (int) Math.pow(2, i);
            if (ans == n) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPowerOfTwo2(int n) {
        //Powers of 2 in binary look like: 1 → 0001, 2 → 0010 etc
        //8 = 1000 (binary)
        //8 - 1 = 0111
        //So: 8 & 7 = 1000 & 0111 = 0000 (zero)

        return n > 0 &&
                (n & (n - 1)) == 0;
        /*
        isPowerOfTwo(18) → (18 > 0) && (18 & (18 - 1)) == 0
                → (true) && (18 & 17) == 0
                → (true) && (10010 & 10001) == 10000 (not zero)
                → false
         */
    }

    public static void  main(String args[]){
        int n=16;
        System.out.println(isPowerOfTwo(n));
        System.out.println(isPowerOfTwo2(n));
    }
}

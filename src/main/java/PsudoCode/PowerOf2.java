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

    public static void  main(String args[]){
        int n=24;
        System.out.println(isPowerOfTwo(n));
    }
}

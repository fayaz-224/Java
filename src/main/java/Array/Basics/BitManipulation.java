package Array.Basics;

public class BitManipulation {

    static void getBit(int n, int pos){  //left shift + AND
        int bitMask = 1 << pos;

        if((bitMask & n) == 0) {
            System.out.println("bit was zero");
        } else {
            System.out.println("bit was one");
        }
    }

    static void setBit(int n, int pos) {  //left shift + OR
        int bitMask = 1 << pos;

        int newNumber = bitMask | n;
        System.out.println(newNumber);

    }

    static void clearBit(int n, int pos) {  //left shift then Negate + AND
        int bitMask = 1 << pos;
        int newBitMask = ~(bitMask);

        int newNumber = newBitMask & n;
        System.out.println(newNumber);
    }

    static void updateBit(int n, int pos, int oper) {
        int bitMask = 1<<pos;

        if(oper == 1) { //oper=1 -> set; oper=0 -> clear;
            //set
            int newNumber = bitMask | n;
            System.out.println(newNumber);
        } else {
            //clear
            int newBitMask = ~(bitMask);
            int newNumber = newBitMask & n;
            System.out.println(newNumber);
        }
    }

    public static void main(String args[]) {
        int n = 5;  //0101
        int pos = 2;

        getBit(n, pos); //bit was one
        setBit(n, pos); //5 (0101)
        clearBit(n, pos); //1 (0001)
        updateBit(n, pos, 1); //5 (0101)

    }
}

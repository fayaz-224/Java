package Patterns;

/*
 *      *
 **    **
 * *  * *
 *  **  *
 *  **  *
 * *  * *
 **    **
 *      *
 */
public class HollowButterfly {
    public static void main(String[] args) {
        int n = 4;

        //upper part
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            for (int j = 1; j <= 2 * (n - i); j++) {    //imp
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        //lower part
        for (int i = n-1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            for (int j = 1; j <= 2 * (n - i); j++) {    //imp
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
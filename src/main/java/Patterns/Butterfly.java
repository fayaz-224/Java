package Patterns;

/*
 *      *
 **    **
 ***  ***
 ********
 ***  ***
 **    **
 *      *
 */
public class Butterfly {
    public static void main(String[] args) {
        int n = 4;

        //upper part
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for(int j=i;j<n;j++) {
                System.out.print("  ");  // 2 spaces to maintain symmetry or use below code
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //lower part
        for (int i = n-1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for(int j=i;j<n;j++) {
                System.out.print("  ");  // 2 spaces to maintain symmetry or use below code
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

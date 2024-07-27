package Special;

/*
3 3 3 3 3 3 3
3 2 2 2 2 2 3
3 2 1 1 1 2 3
3 2 1 0 1 2 3
3 2 1 1 1 2 3
3 2 2 2 2 2 3
3 3 3 3 3 3 3
 */
public class IllusionPattern {
    public static void main(String[] args) { //from high to lower
        int size = 3;
        int n = 2 * size;
        for (int row = 0; row <= n; row++) {  //0 to n as we are considering o/p with 0, n
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = size - Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}


/*
public class IllusionPattern { //for low to higher
    public static void main(String[] args) {
        int size = 4;
        int n = 2 * size;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}
 */
package Array;
// the sum of the two numbers immediately above it.
//    1
//   1 1
//  1 2 1
// 1 3 3 1
//1 4 6 4 1

//Print the element at position (row, col) in Pascal’s triangle.
//Approach1: generate pascal triangle, return value at given index
//Approach2: as below
public class ElementInPascal {

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void pascalRow(int row) {
        int n = row-1;
        for (int col = 1; col <= row; col++) { // printing the entire row n:
            int r = col-1;
            System.out.print(factorial(n) / (factorial(r) * factorial(n - r)) + " ");
        }
    }

    public static int pascalElement(int row, int col) {
        int n = row - 1;
        int r = col - 1;
        //formula: nCr = n! / (r! * (n-r)!)
        return  factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void main(String[] args) {
        int r = 5; // row number
        int c = 4; // col number
        int element = pascalElement(r, c);
        System.out.println("The element at position (r,c) is: " + element);

        System.out.println(r + "th row of Pascal’s triangle:");
        pascalRow(r);

    }
}
//Time Complexity: O(c), where c = given column number.
//Space Complexity: O(1) as we are not using any extra space.
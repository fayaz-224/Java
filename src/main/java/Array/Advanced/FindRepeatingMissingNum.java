package Array.Advanced;

//Given array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing.
// The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.
public class FindRepeatingMissingNum {
    public static int[] findMissingRepeatingNumbers(int[] a) {
        int n = a.length; // size of the array
        int[] temp = new int[n + 1]; // hash array

        for (int i = 0; i < n; i++) {
            temp[a[i]]++;       //ex: Code encounters the element 3 at index 0. It updates temp[3] by incrementing its value from 0 to 1.
        }

        //Find the repeating and missing number
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (temp[i] == 2) repeating = i;
            else if (temp[i] == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans = findMissingRepeatingNumbers(a);
        System.out.println("The repeating and missing numbers are: {"
                + ans[0] + ", " + ans[1] + "}");
    }
}

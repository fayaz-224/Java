package DSA.BinarySearch;

import java.util.Arrays;

//Find the count of elements in the first array that have no corresponding element in the second array with an absolute difference less than or equal to d.
public class ComparatorValue {

    //O(n × m)
    public static int comparatorValue(int[] a, int[] b, int d) {
        int count = 0;

        for (int x : a) {
            boolean hasClose = false;
            for (int y : b) {
                if (Math.abs(x - y) <= d) {
                    hasClose = true;
                    break;
                }
            }

            if (!hasClose) {  //not true -> count
                count++;
            }
        }
        return count;
    }

    //Binary search - O(m log m)
    public static int comparatorValue2(int[] a, int[] b, int d) {
        Arrays.sort(b); // Sort b for binary search
        int count = 0;

        for (int x : a) {
            int pos = Arrays.binarySearch(b, x); // If element not found, Arrays.binarySearch returns -(insertionPoint) - 1

            if (pos < 0) {
                pos = -(pos + 1); //This reverses the negative result to get the insertion index
            }

            boolean hasClose = false;
            // At index pos, two numbers in b are closest to x. Check those elements (b[pos - 1], b[pos])
            if (pos < b.length && Math.abs(b[pos] - x) <= d) {
                hasClose = true;
            }
            else if (pos > 0 && Math.abs(b[pos - 1] - x) <= d) {
                hasClose = true;
            }

            if (!hasClose) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {3,1,5};
        int[] b = {5,6,7};
        int d = 1;

        System.out.println(comparatorValue(a, b, d)); // Output: 1
    }
}

/*
Step-by-Step Calculation
For a[0] = 3
|3 - 5| = 2, |3 - 6| = 3, |3 - 7| = 4 → all > 1
✅ Counts (no element in b within distance 1)

For a[1] = 1
|1 - 5| = 4, |1 - 6| = 5, |1 - 7| = 6 → all > 1
✅ Counts

For a[2] = 5
|5 - 5| = 0 → ≤ 1 ❌ (has a close element)
 */
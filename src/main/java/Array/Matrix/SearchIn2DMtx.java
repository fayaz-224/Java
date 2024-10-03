package Array.Matrix;

import java.util.*;

//Brute force: O(N X M) - using 2 for loops to find target
public class SearchIn2DMtx {  //Optimal approach: O(log(NxM))
    public static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size();
        int m = matrix.get(0).size();

        //range of the indices of the imaginary 1D array is [0, (NxM)-1] here, we will apply binary search.
        //When comparing elements, we will convert the index to the cell number and retrieve the element.
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;  //imp
            if (matrix.get(row).get(col) == target)
                return true;
            else if (matrix.get(row).get(col) < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(); //we can use Mtx too
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        matrix.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8)));
        matrix.add(new ArrayList<>(Arrays.asList(9, 10, 11, 12)));

        boolean result = searchMatrix(matrix, 8);
        System.out.println(result ? "true" : "false");
    }
}




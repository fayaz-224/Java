package Array.Basics;

import java.util.List;
import java.util.ArrayList;

//Maintain the order of numbers
public class AlternatePos_Neg {

    static int[] rearrangeBySign(int[] A, int n) {  //O(N) - works for unequal no. of positive and negative elements.
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (A[i] >= 0)
                pos.add(A[i]); // Add to positives
            else
                neg.add(A[i]); // Add to negatives
        }

        int[] res = new int[n];
        int i = 0, p = 0, q = 0;
        while (p < pos.size() && q < neg.size()) {
            res[i++] = pos.get(p++);
            res[i++] = neg.get(q++);
        }
        while (p < pos.size()) res[i++] = pos.get(p++);
        while (q < neg.size()) res[i++] = neg.get(q++);

        return res;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 6, 7, -4, -5};
        int n = A.length;

        int[] result = rearrangeBySign(A, n);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

package DSA.Recursion_Backtracking;

public class TowerOfHonai {
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 0)
            return;

        towerOfHanoi(n - 1, src, dest, helper); //transfer top n-1 from src to helper using dest as 'helper'
        System.out.println("transfer disk " + n + " from " + src + " -> " + dest); //transfer nth from src to dest
        towerOfHanoi(n - 1, helper, src, dest); //transfer n-1 from helper to dest using src as 'helper'
    }

    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, "S", "H", "D");
    }
}

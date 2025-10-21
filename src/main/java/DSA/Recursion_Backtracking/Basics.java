package DSA.Recursion_Backtracking;

public class Basics {

    //power of n
    private static int pow(int n, int p) {
        if(p==0) return 1;
        return n * pow(n, p-1);
    }

    //sum of n
    private static int sum(int n) {
        if(n==1) return 1;
        return n + sum(n-1);
    }

    //gives count of possible paths in a given nXm grid (were we can only move RIGHT or DOWN in mtx)
    //TC: O(2^max(m,n))
    //https://leetcode.com/problems/unique-paths/description/
    private static int path(int m, int n) {
        if(m==1 || n==1) return 1;
        return path(m-1, n) + path(m, n-1);   // Recursively count paths by considering moving right and down
    } //Better use DP logic

    public static void main(String[] args){
        System.out.println("-----POW-----");
        System.out.println(pow(3,3)); //27
        System.out.println(pow(3,0)); //1
        System.out.println("-----PATH-----");
        System.out.println(path(2,3)); //3
        System.out.println(path(10,1)); //1
        System.out.println(path(1,0)); //1
        System.out.println("-----SUM-----");
        System.out.println(sum(3)); //6
        System.out.println(sum(10)); //55
    }
}

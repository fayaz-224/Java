package DSA.Recursion_Backtracking;

//Time Complexity: O(2^n)
//Space Complexity: O(n), recursion stack.
public class AllPossibleSubstrings {
    static int count = 0;
    static void solve(int i, String str, String newStr) {
        if (i == str.length()) {
            System.out.print(newStr+" ");
            count++;
            return;
        }
        // pick
        solve(i+1, str,  newStr+str.charAt(i));
        // don't pick
        solve(i + 1, str,  newStr);
    }

    public static void main(String args[]) {
        String s = "abc";
        System.out.print("All possible subsequences are: ");
        solve(0, s, "");
        System.out.println("\ncount: " + count);
    }
}

/*
public class AllSubstrings {  //O(n^2) better than recursion

    public static void main(String[] args) {
        String s = "abc";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.print(s.substring(i, j) + " ");
                count++;
            }
        }
        System.out.println("\nCount: " + count);
    }
}
 */
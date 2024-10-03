package DSA.Recursion;

//Time Complexity: O(2^n)
//Space Complexity: O(n), recursion stack.
public class AllPossibleSubstrings {  //power set
    static int count = 0;
    static void solve(int i, String str, String newStr) {
        if (i == str.length()) {
            System.out.print(newStr+" ");
            count++;
            return;
        }
        // picking
        solve(i+1, str,  newStr+str.charAt(i));
        // poping out while backtracking
        solve(i + 1, str,  newStr);  //Now while backtracking we have to pop the last character since now we have to implement the non-pick condition and then move to next index.
    }

    public static void main(String args[]) {
        String s = "abc";
        System.out.print("All possible subsequences are: ");
        solve(0, s, "");
        System.out.println("\ncount: " + count);
    }
}

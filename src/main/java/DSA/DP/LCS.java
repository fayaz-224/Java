package DSA.DP;

//Longest Common Subsequence
public class LCS {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(getLCS(text1, text2, 0, 0));
    }

    //Using Recursion
    public static int getLCS(String text1, String text2, int i, int j){
        if(i<0 || i==text1.length() || j<0 || j==text2.length())
            return 0;

        int ans;
        if(text1.charAt(i) == text2.charAt(j))
            ans =  1 + getLCS(text1,text2,i+1,j+1);
        else
            ans = Math.max(getLCS(text1,text2,i,j+1), getLCS(text1,text2,i+1,j));

        return ans;  //we can also directly return in if-else blocks instead of storing in ans.
    }
}

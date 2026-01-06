package Strings.Basics;

//https://leetcode.com/problems/reverse-words-in-a-string/description/
public class ReverseWordsInString {

    static String reverseWords (String s) {
        String arr[] = s.trim().split("\\s+");
        int i = 0, j= arr.length-1;  //2 pointers
        while(i < j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        //or
        //StringBuilder res = new StringBuilder();
        //for (int i = arr.length-1; i >= 0; i--)
        //    res.append(arr[i]).append(" ");
        //return res.toString().trim();
        return String.join(" ", arr); //Join() Concatenates array elements with given Delimiter
    }

    //Without using string functions
    public static String reverseWordsBrute(String s) {
        char[] arr = s.toCharArray();
        StringBuilder result = new StringBuilder();

        int i = arr.length - 1;
        while (i >= 0) { // Traverse from right to left

            // skip spaces
            while (i >= 0 && arr[i] == ' ') i--;

            if (i < 0) break;

            // Mark end of word
            int end = i;

            // find word start
            while (i >= 0 && arr[i] != ' ') i--;

            int start = i + 1;

            // append word
            for (int k = start; k <= end; k++) { // or use s.substring(start, end + 1);
                result.append(arr[k]);
            }
            result.append(' ');
        }

        // remove trailing space manually
        if (result.length() > 0)
            result.setLength(result.length() - 1);

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Java Concept Of The Day"));  //OP: Day The Of Concept Java
    }
}

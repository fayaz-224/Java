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
        return String.join(" ", arr); //Join() Concatenates given array elements with given Delimiter
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Java Concept Of The Day"));  //OP: Day The Of Concept Java
    }
}


/*
//Brute Force
public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();

        for (int i = words.length-1; i >= 0; i--)
            res.append(words[i]).append(" ");

        return res.toString().trim();
    }
 */
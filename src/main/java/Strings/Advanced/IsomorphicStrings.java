package Strings.Advanced;

import java.util.HashMap;
import java.util.Map;

//two strings str1 and str2 are isomorphic, we need to check if there exists a one-to-one mapping between characters
//Input:  str1 = “aab”, str2 = “xxy”
//Output: True
//Explanation: ‘a’ is mapped to ‘x’ and ‘b’ is mapped to ‘y’.
//
//Input:  str1 = “aab”, str2 = “xyz”
//Output: False
//Explanation: One occurrence of ‘a’ in str1 has ‘x’ in str2 and other occurrence of ‘a’ has ‘y’.
public class IsomorphicStrings {

    public static boolean areIsomorphic(String str1, String str2) {
        //If str1 and str2 have different lengths, they cannot be isomorphic.
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if(map.containsKey(str1.charAt(i))) {
                if(map.get(str1.charAt(i)) != str2.charAt(i))
                    return false;
            } else if(map.containsValue(str2.charAt(i))) {
                return false;
            } else {
                map.put(str1.charAt(i), str2.charAt(i));
            }
        }
        return true;
    }

    //https://leetcode.com/problems/word-pattern/
    private static boolean findWordMatch(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] str = s.split("\\s+");
        if (pattern.length() != str.length)
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(str[i]))
                    return false;
            } else if (map.containsValue(str[i]))
                return false;
            else
                map.put(pattern.charAt(i), str[i]);

        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "egg", str2 = "add";  //true
        System.out.println("Are '" + str1 + "' and '" + str2 + "' isomorphic? " + areIsomorphic(str1, str2));

        String str3 = "foo", str4 = "bar";  //false
        System.out.println("Are '" + str3 + "' and '" + str4 + "' isomorphic? " + areIsomorphic(str3, str4));

        String pattern = "abba", s = "dog dog dog dog";  //false
        System.out.println("Are '" + pattern + "' and '" + s + "' isomorphic? " + findWordMatch(pattern, s));
    }
}

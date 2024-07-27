package Strings;

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

        Map<Character, Character> map1 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if(map1.containsKey(str1.charAt(i))) {
                if(map1.get(str1.charAt(i)) != str2.charAt(i))
                    return false;
            } else if(map1.containsValue(str2.charAt(i))) {
                return false;
            } else {
                map1.put(str1.charAt(i), str2.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "egg";
        String str2 = "add";
        System.out.println("Are '" + str1 + "' and '" + str2 + "' isomorphic? " + areIsomorphic(str1, str2));

        String str3 = "foo";
        String str4 = "bar";
        System.out.println("Are '" + str3 + "' and '" + str4 + "' isomorphic? " + areIsomorphic(str3, str4));

        String str5 = "paper";
        String str6 = "title";
        System.out.println("Are '" + str5 + "' and '" + str6 + "' isomorphic? " + areIsomorphic(str5, str6));
    }
}

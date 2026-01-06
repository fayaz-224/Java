package Strings.Basics;

public class StringRotation {
    public static void main(String[] args) {
        String str1 = "rotation";
        String str2 = "tionrota";

        if (areRotations(str1, str2)) {
            System.out.println("String 2 is a rotation of String 1");
        } else {
            System.out.println("String 2 is not a rotation of String 1");
        }
    }

    public static boolean areRotations(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        String concatenated = str1 + str1;
        return concatenated.contains(str2); // Check if str2 is a substring of the concatenated string
    }

    public boolean rotateString(String s, String goal) {  //Bruteforce
        if (s.length() != goal.length()) {
            return false;
        }

        // Try all possible rotations of s
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal)) {
                return true;
            }
        }
        return false;
    }
}

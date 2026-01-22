package JavaConcepts.PsudoCode;

public class StringCompare {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = "abc";
        String s4 = "abc";
        String s5 = "cba";

        System.out.println(s1 == s2);   //false
        System.out.println(s1.equals(s2));  //true
        System.out.println(s1 == s3);   //false
        System.out.println(s1.equals(s3));  //true
        System.out.println(s3 == s4);  //true
        System.out.println(s3.equals(s4));  //true

        System.out.println(s4.compareTo(s5));   //-2
        System.out.println(s5.compareTo(s4));   //2


    }
}

package Strings.Basics;

public class StringCountInGivenText {  //matches non-absolute strings
    static int countOfString(String text) {
        String str="balloon";
        char[] ch = text.toCharArray();
        int i,j,count=0;
        // we had to take infinite loop, as we need to check string until end of given text whose length is unknown.
        while(true)
        {
            for(i=0;i<str.length();i++) {
                for(j=0;j<ch.length;j++) {
                    if(str.charAt(i)==ch[j]) {
                        ch[j]=0;  //to avoid visited ones
                        break;
                    }
                }

                if(j==ch.length)
                    return count;
            }
            count++;
        }
    }

    public static void main(String args[]) {
        String msg = "The ballddddoons are so beautiful, red balloons are my fav";
        System.out.println(countOfString(msg));
    }
}


/*
public class StringCountInGivenText {  //matches absolute strings
    public static void main(String[] args) {
        String text = "This is a sample text to demonstrate string counting. This text contains sample words.";
        String searchString = "sample";

        int count = 0;
        int index = text.indexOf(searchString);
        while (index != -1) {
            count++;
            index = text.indexOf(searchString, index + 1);
        }
        System.out.println("The string '" + searchString + "' appears " + count + " times in the text.");
    }
}

 */
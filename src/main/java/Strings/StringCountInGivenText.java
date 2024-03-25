package Strings;

public class StringCountInGivenText {
    static int countOfString(String text) {
        String str="balloon";
        char[] ch = text.toCharArray();
        int i,j,count=0;
        // we had to take infinite loop, as we need to check string until end of given text whose len is unknown.
        while(true)
        {
            for(i=0;i<str.length();i++){
                for(j=0;j<ch.length;j++){
                    if(str.charAt(i)==ch[j]){
                        ch[j]=0;
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
        String msg = "The balloons are so beautiful, red balloons are my fav";
        System.out.println(countOfString(msg));
    }
}

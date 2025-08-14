package PsudoCode;

import java.util.ArrayList;
import java.util.Random;

public class RandomNum {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            int randomNum = rand.nextInt(10); // random integer between 0 and 9. Give 100 if you need 0 to 99
            numbers.add(randomNum);
        }

        System.out.println("Random Numbers: " + numbers);
    }
}

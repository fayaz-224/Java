package UnitTests;

import Strings.Basics.Palindrome;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FactorialTest {

    @ParameterizedTest
    @ValueSource(strings = {"madam", "afrid", "racecar", "fayaz"}) //for int use ints = {}
    public void test1(String str) {
        Palindrome p = new Palindrome();
        boolean actual = p.isPalindrome(str);
        assertTrue(actual);
    }
}

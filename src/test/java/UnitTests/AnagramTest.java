package UnitTests;

import Strings.Anagram;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {
    @Before
    public void beforeAll() {
        System.out.println("Before Executed");
    }

    @BeforeClass
    public static void beforeClassDemo() {    //Class level so, static
        System.out.println("BeforeClass Executed");
    }

    @Test
    public void test1() {
        boolean actual = Anagram.checkAnagram("fayaz", "shaik"); //since it is static method
        assertFalse(actual); // if not false, returns AssertionError
    }

    @Test
    public void test2() {
        boolean actual = Anagram.checkAnagram("fayaz", "faazy");
        assertTrue(actual);
    }

    @After
    public void afterAll() {
        System.out.println("After Executed");
    }

    @AfterClass
    public static void afterClassDemo() {    //Class level so, static
        System.out.println("AfterClass Executed");
    }
}

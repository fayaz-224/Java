package UnitTests;

import Strings.Basics.Anagram;
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {

    //Before each Test case - used to set any counters etc
    @Before //Junit4
    public void beforeEachOld() {
        System.out.println("Before Executed");
    }
    @BeforeEach //Junit5
    public void beforeEach() {
        System.out.println("BeforeEach Executed");
    }

    //Before all Test cases - used to initialize something, open connections etc
    @BeforeClass //Junit4
    public static void beforeClassDemo() {    //Class level annotation, so static
        System.out.println("BeforeClass Executed");
    }
    @BeforeAll //Junit5
    public static void beforeAllDemo() {    //Class level annotation, so static
        System.out.println("BeforeAll Executed");
    }

    @Test
    public void test1() {
        boolean actual = Anagram.checkAnagram("fayaz", "shaik"); //calling directly, since it is static method
        assertFalse(actual); // if not false, returns AssertionError
    }

    @Test
    public void test2() {
        boolean actual = Anagram.checkAnagram("fayaz", "faazy");
        assertTrue(actual);
    }

    //After each Test case - used to reset counters etc
    @After //Junit4
    public void afterEachOld() {
        System.out.println("After Executed");
    }
    @AfterEach //Junit5
    public void afterEach() {
        System.out.println("AfterEach Executed");
    }

    //After all Test cases - used to close connections etc
    @AfterClass //Junit4
    public static void afterClassDemo() {    //Class level so, static
        System.out.println("AfterClass Executed");
    }
    @AfterAll //Junit5
    public static void afterAllDemo() {    //Class level so, static
        System.out.println("AfterAll Executed");
    }
}

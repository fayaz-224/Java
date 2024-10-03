package UnitTests;

import Array.Basics.Fibanocci;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibanocciTest {

    @BeforeAll
    public static void beforeAllTC() {
        System.out.println("Executing fib");
    }  //should be static

    //@Test(timeout = 2000)      //TC will fail if execution took more than 2 ms - JUnit4
    @Test
    public void test1() {
        int actual = Fibanocci.nthFibNumber(5);  //gives nth fib number
        System.out.println(actual);
        assertEquals(3, actual);
    }

    @Test
    @Disabled  //to disable any TC
    public void test2() {
        int actual = Fibanocci.nthFibNumber(1);  //gives nth fib number
        System.out.println(actual);
        assertEquals(1, actual);
    }

    @AfterAll
    public static void afterAllTC() {
        System.out.println("completed");
    }
}


//@Tag
//@Nested
//@DisplayName()
//@Timeout()
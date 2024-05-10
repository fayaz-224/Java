package UnitTests;

import Basics.Fibanocci;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibanocciTest {
    @Before
    public void beforeAll() {
        System.out.println("Executing fib");
    }

    @Test
    public void test1() {
        int actual = Fibanocci.nthFibNumber(5);  //gives nth fib number
        System.out.println(actual);
        assertEquals(3, actual);
    }

    @After
    public void afterAll() {
        System.out.println("completed");
    }
}

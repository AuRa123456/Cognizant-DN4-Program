// Exercise 2: Writing Basic JUnit Tests

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    MathUtils math = new MathUtils();

    @Test
    void testAdd() {
        assertEquals(8, math.add(5, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(2, math.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, math.multiply(5, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, math.divide(10, 5));
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> math.divide(10, 0));
    }
}
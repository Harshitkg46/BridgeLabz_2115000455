
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Arithmetic {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}

public class DivideTest {
    Arithmetic arithmetic = new Arithmetic();

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> arithmetic.divide(5, 0));
    }

    @Test
    void testDivide() {
        assertEquals(2, arithmetic.divide(6, 3));
    }
}

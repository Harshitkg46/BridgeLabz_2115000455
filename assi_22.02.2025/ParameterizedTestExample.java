
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtils {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

public class ParameterizedTestExample {
    NumberUtils utils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsEven(int number) {
        assertTrue(utils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testIsNotEven(int number) {
        assertFalse(utils.isEven(number));
    }
}

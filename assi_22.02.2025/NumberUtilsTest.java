
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtils {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

public class NumberUtilsTest {
    NumberUtils numberUtils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    public void testIsEven_True(int number) {
        assertTrue(numberUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    public void testIsEven_False(int number) {
        assertFalse(numberUtils.isEven(number));
    }
}

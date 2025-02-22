
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtils {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}

public class StringUtilsTest {
    StringUtils utils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("cba", utils.reverse("abc"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(utils.isPalindrome("madam"));
        assertFalse(utils.isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
    }
}

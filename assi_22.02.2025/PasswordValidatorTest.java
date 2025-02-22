
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PasswordValidator {
    public boolean isValid(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\d.*");
    }
}

public class PasswordValidatorTest {
    PasswordValidator validator = new PasswordValidator();

    @Test
    public void testValidPassword() {
        assertTrue(validator.isValid("StrongPass1"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(validator.isValid("weak"));
        assertFalse(validator.isValid("NoDigitsHere"));
        assertFalse(validator.isValid("short1"));
    }
}

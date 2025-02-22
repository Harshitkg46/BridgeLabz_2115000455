
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty() || 
            email == null || !email.contains("@") || 
            password == null || password.length() < 8) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}

public class UserRegistrationTest {
    UserRegistration registration = new UserRegistration();

    @Test
    public void testValidRegistration() {
        assertDoesNotThrow(() -> registration.registerUser("john_doe", "john@example.com", "StrongPass1"));
    }

    @Test
    public void testInvalidRegistration() {
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("", "invalid", "weak"));
    }
}

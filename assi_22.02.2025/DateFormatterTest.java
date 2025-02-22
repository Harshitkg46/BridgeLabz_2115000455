
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class DateFormatter {
    public String formatDate(String inputDate) {
        try {
            LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }
}

public class DateFormatterTest {
    DateFormatter formatter = new DateFormatter();

    @Test
    public void testValidDate() {
        assertEquals("25-12-2025", formatter.formatDate("2025-12-25"));
    }

    @Test
    public void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("25/12/2025"));
    }
}

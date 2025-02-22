
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TemperatureConverter {
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}

public class TemperatureConverterTest {
    TemperatureConverter converter = new TemperatureConverter();

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32, converter.celsiusToFahrenheit(0));
        assertEquals(212, converter.celsiusToFahrenheit(100));
    }

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32));
        assertEquals(100, converter.fahrenheitToCelsius(212));
    }
}

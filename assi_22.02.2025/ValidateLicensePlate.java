
import java.util.regex.*;
public class ValidateLicensePlate {
    public static void main(String[] args) {
        String[] plates = {"AB1234", "A12345"};
        for (String plate : plates) {
            if (plate.matches("^[A-Z]{2}\d{4}$")) {
                System.out.println(plate + " → Valid");
            } else {
                System.out.println(plate + " → Invalid");
            }
        }
    }
}

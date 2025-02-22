
import java.util.regex.*;
public class ValidateSSN {
    public static void main(String[] args) {
        String[] ssns = {"123-45-6789", "123456789", "123-456-789"};
        for (String ssn : ssns) {
            if (ssn.matches("^\d{3}-\d{2}-\d{4}$")) {
                System.out.println(ssn + " → Valid SSN");
            } else {
                System.out.println(ssn + " → Invalid SSN");
            }
        }
    }
}

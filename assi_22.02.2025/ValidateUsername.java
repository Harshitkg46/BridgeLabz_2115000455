
import java.util.regex.*;
public class ValidateUsername {
    public static void main(String[] args) {
        String[] usernames = {"user_123", "123user", "us"};
        for (String username : usernames) {
            if (username.matches("^[a-zA-Z][\w]{4,14}$")) {
                System.out.println(username + " → Valid");
            } else {
                System.out.println(username + " → Invalid");
            }
        }
    }
}

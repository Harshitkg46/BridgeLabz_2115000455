
import java.util.regex.*;
public class ValidateHexColorCode {
    public static void main(String[] args) {
        String[] colors = {"#FFA500", "#ff4500", "#123"};
        for (String color : colors) {
            if (color.matches("^#[0-9A-Fa-f]{6}$")) {
                System.out.println(color + " → Valid");
            } else {
                System.out.println(color + " → Invalid");
            }
        }
    }
}

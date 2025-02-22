
import java.util.regex.*;
public class ExtractEmails {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        Pattern pattern = Pattern.compile("[\w.-]+@[\w.-]+\.\w+");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Emails:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

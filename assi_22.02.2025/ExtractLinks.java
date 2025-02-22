
import java.util.regex.*;
public class ExtractLinks {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        Pattern pattern = Pattern.compile("https?://\S+");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Links:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}


import java.util.regex.*;
public class ValidateCreditCard {
    public static void main(String[] args) {
        String[] cards = {"4111111111111111", "5111111111111111", "6111111111111111"};
        for (String card : cards) {
            if (card.matches("^4\d{15}$")) {
                System.out.println(card + " → Valid Visa Card");
            } else if (card.matches("^5\d{15}$")) {
                System.out.println(card + " → Valid MasterCard");
            } else {
                System.out.println(card + " → Invalid Card");
            }
        }
    }
}

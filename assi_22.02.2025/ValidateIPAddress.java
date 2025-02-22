
import java.util.regex.*;
public class ValidateIPAddress {
    public static void main(String[] args) {
        String[] addresses = {"192.168.0.1", "256.100.50.0", "127.0.0.1"};
        for (String address : addresses) {
            if (address.matches("^(25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)(\.(25[0-5]|2[0-4]\d|1\d{2}|[1-9]?\d)){3}$")) {
                System.out.println(address + " → Valid");
            } else {
                System.out.println(address + " → Invalid");
            }
        }
    }
}

import java.time.LocalDate;
import java.util.Scanner;
public class q4 {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       LocalDate date1 = LocalDate.parse(scanner.next());
       LocalDate date2 = LocalDate.parse(scanner.next());
       if (date1.isBefore(date2)) {
           System.out.println(date1 + " is before " + date2);
       } else if (date1.isAfter(date2)) {
           System.out.println(date1 + " is after " + date2);
       } else {
           System.out.println("Both dates are the same");
       }
       scanner.close();
   }
}

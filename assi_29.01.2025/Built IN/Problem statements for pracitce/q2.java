import java.time.LocalDate;
import java.util.Scanner;
public class q2 {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String dateInput = scanner.next();
       LocalDate date = LocalDate.parse(dateInput);
       LocalDate newDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
       System.out.println("Updated Date: " + newDate);
       scanner.close();
   }
}

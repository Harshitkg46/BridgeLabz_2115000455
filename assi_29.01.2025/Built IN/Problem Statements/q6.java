import java.util.*;
public class q6 {
   // TODO Auto-generated method stub
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println(factorial(scanner.nextInt()));
       scanner.close();
   }
   static int factorial(int n) {
       return n <= 1 ? 1 : n * factorial(n - 1);
   }
}

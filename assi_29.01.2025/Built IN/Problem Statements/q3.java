import java.util.*;
public class q3 {
   // TODO Auto-generated method stub
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int num = scanner.nextInt();
       System.out.println(isPrime(num) ? "Prime" : "Not Prime");
       scanner.close();
   }
   static boolean isPrime(int n) {
       if (n < 2) return false;
       for (int i = 2; i <= Math.sqrt(n); i++) {
           if (n % i == 0) {
           	return false;
           }
       }
       return true;
   }
}

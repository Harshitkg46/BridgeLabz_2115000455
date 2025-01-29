import java.util.*;
public class q2 {
   // TODO Auto-generated method stub
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
       System.out.println(Math.max(a, Math.max(b, c)));
       scanner.close();
   }
}

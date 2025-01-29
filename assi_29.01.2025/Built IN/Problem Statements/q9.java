import java.util.*;
public class q9 {
	// TODO Auto-generated method stub
public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int a = scanner.nextInt(), b = scanner.nextInt();
       String op = scanner.next();
       System.out.println(op.equals("+") ? add(a, b) : op.equals("-") ? subtract(a, b) : op.equals("*") ? multiply(a, b) : divide(a, b));
       scanner.close();
   }
   static int add(int a, int b) {
       return a + b;
   }
   static int subtract(int a, int b) {
       return a - b;
   }
   static int multiply(int a, int b) {
       return a * b;
   }
   static double divide(int a, int b) {
       return b != 0 ? (double) a / b : Double.NaN;
   }
}

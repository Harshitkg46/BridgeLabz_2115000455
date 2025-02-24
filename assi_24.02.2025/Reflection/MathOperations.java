import java.lang.reflect.Method;
import java.util.Scanner;
class MathOperations {
   public int add(int a, int b) {
       return a+b;
   }
   public int subtract(int a, int b) {
       return a-b;
   }
   public int multiply(int a, int b) {
       return a*b;
   }
}
public class DynamicInvokeMethods{
   public static void main(String[] args) {
       try (Scanner sc = new Scanner(System.in)) {
           MathOperations mathOps = new MathOperations();
           System.out.println("Enter method names: ");
           String methodName = sc.next();
           System.out.println("Enter two numbers: ");
           int num1 = sc.nextInt();
           int num2 = sc.nextInt();
           // Using Reflection to get the method
           Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
           // Invoking the method dynamically
           Object result = method.invoke(mathOps, num1, num2);
           System.out.println("Result: " + result);
       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }
   }
}

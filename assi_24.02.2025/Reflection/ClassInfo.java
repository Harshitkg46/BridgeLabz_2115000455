import java.lang.reflect.*;
import java.util.Scanner;
public class ClassInfo{
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter the class name:");
       String className = sc.nextLine();
       try {
           Class<?> clas = Class.forName(className);
           System.out.println("\nClass Name: " + clas.getName());
           // Display Constructors
           System.out.println("\nConstructors:");
           Constructor<?>[] constructors = clas.getDeclaredConstructors();
           for (Constructor<?> constructor : constructors) {
               System.out.println(constructor);
           }
           // Display Fields
           System.out.println("\nFields:");
           Field[] fields = clas.getDeclaredFields();
           for (Field field : fields) {
               System.out.println(field);
           }
           // Display Methods
           System.out.println("\nMethods:");
           Method[] methods = clas.getDeclaredMethods();
           for (Method method : methods) {
               System.out.println(method);
           }
       } catch (ClassNotFoundException e) {
           System.out.println("Class not found: " + className);
       }
   }
}

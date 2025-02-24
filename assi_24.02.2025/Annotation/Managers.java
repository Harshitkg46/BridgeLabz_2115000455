import java.lang.annotation.*;
import java.lang.reflect.*;

// Defining custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
   String level() default "HIGH";
}
class Managers{
   @ImportantMethod
   public void criticalProcess() {
       System.out.println("Executing critical process");
   }

   @ImportantMethod(level = "MEDIUM")
   public void normalProcess() {
       System.out.println("Executing normal process");
   }
}
public class ImportantMethodsClass{
   public static void main(String[] args) throws Exception {
       Managers task = new Managers();
       Method[] methods = task.getClass().getMethods();

       // Retrieving and printing annotated methods
       for (Method method : methods) {
           if (method.isAnnotationPresent(ImportantMethod.class)) {
               ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
               System.out.println(method.getName() + " , " + annotation.level());
           }
       }
       task.criticalProcess();
       task.normalProcess();
   }
}

import java.lang.annotation.*;
import java.lang.reflect.Method;
// Define Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Author {
   String name();
}
class Test {
   @Author(name = "Harshit Kumar Goyal")
   public void myMethod() {
       System.out.println("Executing this method");
   }
}
public class AnnotationRuntime{
   public static void main(String[] args) throws Exception {
       Test obj = new Test();
       Class<?> cls = obj.getClass();
       // Access method
       Method method = cls.getMethod("myMethod");
       // Check if annotation is present
       if (method.isAnnotationPresent(Author.class)) {
           // Retrieve annotation details
           Author author = method.getAnnotation(Author.class);
           System.out.println("Annotation Value: " + author.name());
       }
       method.invoke(obj);
   }
}

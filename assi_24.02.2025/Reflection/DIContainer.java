import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.*;
// Custom annotation to mark dependencies for injection
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}
class DIContainer {
   private Map<Class<?>, Object> instances = new HashMap<>();
   // Register a class and create an instance
   public <T> void register(Class<T> clas) throws Exception {
       T instance = clas.getDeclaredConstructor().newInstance();
       instances.put(clas, instance);
   }
   public void injectDependencies(Object obj) throws Exception {
       Class<?> clas = obj.getClass();

       for (Field field : clas.getDeclaredFields()) {
           if (field.isAnnotationPresent(Inject.class)) { // Check if field has @Inject
               field.setAccessible(true); // Allow modification of private fields

               Class<?> dependencyType = field.getType();
               Object dependencyInstance = instances.get(dependencyType);

               if (dependencyInstance == null) { // If not registered, create and store
                   dependencyInstance = dependencyType.getDeclaredConstructor().newInstance();
                   instances.put(dependencyType, dependencyInstance);
               }

               field.set(obj, dependencyInstance); // Inject the dependency
           }
       }
   }
}
class ServiceB {
   public void doSomething() {
       System.out.println("Service B, doing something !!");
   }
}
class ServiceA {
   @Inject  // Mark this field for dependency injection
   private ServiceB serviceB;

   public void performAction() {
       serviceB.doSomething(); // Call method on injected instance
   }
}
public class InjectAnnotation{
   public static void main(String[] args) throws Exception {
       DIContainer container = new DIContainer();
       container.register(ServiceB.class);
       ServiceA serviceA = new ServiceA();
       container.injectDependencies(serviceA);
       serviceA.performAction();  // Should print: "ServiceB is doing something!"
   }
}

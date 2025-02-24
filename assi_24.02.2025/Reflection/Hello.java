import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
interface Greeting {
   void sayHello();
}
class Hello implements Greeting {
   public void sayHello() {
       System.out.println("Hello, World!");
   }
}
class CustomInvocationHandler implements InvocationHandler {
   private final Object target;
   public CustomInvocationHandler(Object target) {
       this.target = target;
   }
   @Override
   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       System.out.println("Before method call...");
       Object result = method.invoke(target, args);
       System.out.println("After method call...");
       return result;
   }
}
public class ProxyReflection{
   public static void main(String[] args) {
       Greeting original = new Hello();
       // Create Proxy Instance
       Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
               Hello.class.getClassLoader(),
               new Class[]{Greeting.class},
               new CustomInvocationHandler(original)
       );
       proxyInstance.sayHello();
   }
}

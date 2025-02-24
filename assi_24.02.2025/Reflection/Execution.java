import java.lang.reflect.Method;
class SampleClass {
   public void fastMethod() {
       System.out.println("Executing fast method");
   }
   public void slowMethod() {
       System.out.println("Executing slow method");
       try {
           Thread.sleep(2000); // Simulating a slow method
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}
public class Execution{
   public static void measureExecutionTime(Object obj, String methodName) {
       try {
           Method method = obj.getClass().getMethod(methodName);
           long startTime = System.nanoTime();
           method.invoke(obj);
           long endTime = System.nanoTime();
           System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

   public static void main(String[] args) {
       SampleClass sample = new SampleClass();
       measureExecutionTime(sample, "fastMethod");
       measureExecutionTime(sample, "slowMethod");
   }
}

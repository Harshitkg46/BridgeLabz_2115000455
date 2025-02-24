import java.lang.reflect.Field;
class Configuration {
   private static String API_KEY = "8dbf5d2a37c4178b4b0";
}
public class StaticFeild {
   public static void main(String[] args) throws Exception {
        Class<?> cls = Configuration.class;
       // Access the private static field
       Field field = cls.getDeclaredField("API_KEY");
       field.setAccessible(true); // Allow access to private field
       // Get field value (pass null because it's a static field)
       System.out.println("Old Value: " + field.get(null));
       // Modify field value (pass null since it's static)
       field.set(null, "12acvhjv5ab1");
       // Get modified value
       System.out.println("New Value: " + field.get(null));
   }
}

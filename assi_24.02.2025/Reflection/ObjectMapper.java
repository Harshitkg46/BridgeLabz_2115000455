import java.lang.reflect.Field;
import java.util.*;
class ObjectMapper{
   public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
       T instance = clazz.getDeclaredConstructor().newInstance();
       // Iterate over the map and set field values
       for (Map.Entry<String, Object> entry : properties.entrySet()) {
           String fieldName = entry.getKey();
           Object fieldValue = entry.getValue();
           try {
               Field field = clazz.getDeclaredField(fieldName);
               field.setAccessible(true);
               field.set(instance, fieldValue);
           } catch (NoSuchFieldException e) {
               System.out.println("Field not found: " + fieldName);
           }
       }

       return instance;
   }
}
class Persons{
   private String name;
   private int age;

   @Override
   public String toString() {
       return "Person{name='" + name + "', age=" + age + "}";
   }
}
public class ObjectMappers{
   public static void main(String[] args) throws Exception {
       Map<String, Object> properties = new HashMap<>();
       properties.put("name", "Harshit");
       properties.put("age", 21);

       // Convert map to Person object
       Persons person = ObjectMapper.toObject(Persons.class, properties);
       // Print the created object
       System.out.println(person);
   }
}

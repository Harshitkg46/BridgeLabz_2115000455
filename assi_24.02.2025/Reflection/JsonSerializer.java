import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
class JsonSerializer {
   public static String toJson(Object obj) throws IllegalAccessException {
       if (obj == null) {
           return "null";
       }
       Class<?> clazz = obj.getClass();
       Map<String, String> jsonMap = new HashMap<>();
       // Iterate through all fields
       for (Field field : clazz.getDeclaredFields()) {
           field.setAccessible(true); // Allow access to private fields
           Object value = field.get(obj);
           jsonMap.put(field.getName(), formatValue(value));
       }
       // Convert map to JSON string format
       StringBuilder json = new StringBuilder("{");
       for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
           json.append("\"").append(entry.getKey()).append("\": ").append(entry.getValue()).append(", ");
       }
       if (json.length() > 1) {
           json.setLength(json.length() - 2);
       }
       json.append("}");
       return json.toString();
   }

   private static String formatValue(Object value) {
       if (value instanceof String) {
           return "\"" + value + "\""; // Add quotes for string values
       } else if (value == null) {
           return "null";
       } else {
           return value.toString(); // Convert other types to string
       }
   }
}
class Employee{
   private String name;
   private int age;
   private boolean isStudent;
   public Employee(String name, int age, boolean isStudent) {
       this.name = name;
       this.age = age;
       this.isStudent = isStudent;
   }
}
public class JSonSerializerTest{
   public static void main(String[] args) throws IllegalAccessException {
       Employee person = new Employee("Harshit", 21, true);

       // Convert object to JSON string
       String jsonString = JsonSerializer.toJson(person);

       // Print JSON output
       System.out.println(jsonString);
   }
}

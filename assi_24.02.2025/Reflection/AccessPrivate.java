import java.lang.reflect.Field;
class Person {
   private int age = 25;
}
public class AccessPrivate{
   public static void main(String[] args) throws Exception {
       Person person = new Person();
       Class<?> cls = person.getClass();
       // Access private field
       Field field = cls.getDeclaredField("age");
       field.setAccessible(true); // Allow access to private field
       System.out.println("Old Value: " + field.get(person));
       field.set(person,21);//modifying field value
       System.out.println("New Value: " + field.get(person));
   }
}


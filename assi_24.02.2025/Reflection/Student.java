class Student {
   private String name;
   public Student(String name) {
       this.name = name;
   }
   public void display() {
       System.out.println("Student Name: " + name);
   }
}
public class CreateInstance{
   public static void main(String[] args) throws Exception {
       Class<?> cls = Student.class;
       Constructor<?> constructor = cls.getConstructor(String.class);
       // Create instance dynamically
       Student student = (Student) constructor.newInstance("Harshit");
       // Call method
       student.display();
   }
}

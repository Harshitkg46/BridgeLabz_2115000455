import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
   BugReport[] value();
}

// Defining repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
   String description();
}
class Manager{
   @BugReport(description = "Null pointer exception")
   @BugReport(description = "Index out of bounds error")
   public void process() {
       System.out.println("Processing task");
   }
}
public class RepeatableClass{
   public static void main(String[] args) throws Exception {
       Manager task = new Manager();
       Method method = task.getClass().getMethod("process");
       // Retrieving and printing all bug reports
       if (method.isAnnotationPresent(BugReports.class)) {
           BugReports bugReports = method.getAnnotation(BugReports.class);
           for (BugReport bug : bugReports.value()) {
               System.out.println("Bug Report: " + bug.description());
           }
       }
       task.process();
   }
}

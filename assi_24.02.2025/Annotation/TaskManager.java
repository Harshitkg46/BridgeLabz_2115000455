import java.lang.annotation.*;
import java.lang.reflect.*;
// Defining custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
   String priority();
   String assignedTo();
}
class TaskManager {
   @TaskInfo(priority = "1st", assignedTo = "Rashi Agrawal")
   public void completeTask() {
       System.out.println("Task completed");
   }
}

// Main class
public class CustomAnnotationClass{
   public static void main(String[] args) throws Exception {
       TaskManager task= new TaskManager();
       Method method = task.getClass().getMethod("completeTask");
       if (method.isAnnotationPresent(TaskInfo.class)) {
           TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
           System.out.println("Priority: " + taskInfo.priority());
           System.out.println("Assigned To: " + taskInfo.assignedTo());
       }
       task.completeTask();
   }
}

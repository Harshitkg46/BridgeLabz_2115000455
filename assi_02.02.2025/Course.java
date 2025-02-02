import java.util.Scanner;
class Course {
   String courseName;
   int duration;
   double fee;
   private static String instituteName = "Default Institute";

   public Course(String courseName, int duration, double fee) {
       this.courseName = courseName;
       this.duration = duration;
       this.fee = fee;
   }

   public void display() {
       System.out.println("Course Name: " + courseName);
       System.out.println("Duration: " + duration + " months");
       System.out.println("Fee: " + fee);
       System.out.println("Institute Name: " + instituteName);
   }

   public static void update   (String newName) {
       instituteName = newName;
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter institute name: ");
       String newInstituteName = sc.nextLine();
       Course.update(newInstituteName);

       System.out.print("Enter number of courses: ");
       int numCourses = sc.nextInt();
       sc.nextLine();

       Course[] courses = new Course[numCourses];

       for (int i = 0; i < numCourses; i++) {
           System.out.print("Enter course name: ");
           String name = sc.nextLine();
           System.out.print("Enter duration: ");
           int duration = sc.nextInt();
           System.out.print("Enter fee: ");
           double fee = sc.nextDouble();
           sc.nextLine();
           courses[i] = new Course(name, duration, fee);
       }

       System.out.println("\nCourse Details:");
       for (Course course : courses) {
           course.display();
           System.out.println();
       }
   }
}


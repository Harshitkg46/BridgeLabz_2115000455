import java.util.Scanner;
class University{
   public int rollNumber;
   protected String name;
   private double CGPA;
   public University(int rollNumber, String name, double CGPA) {
       this.rollNumber = rollNumber;
       this.name = name;
       this.CGPA = CGPA;
   }
   public double getCGPA() {
       return CGPA;
   }
   public void setCGPA(double CGPA) {
       this.CGPA = CGPA;
   }
   public void display() {
       System.out.println("Roll Number: " + rollNumber);
       System.out.println("Name: " + name);
       System.out.println("CGPA: " + CGPA);
   }
}
class PostgraduateStudent extends University{
   public PostgraduateStudent(int rollNumber, String name, double CGPA) {
       super(rollNumber, name, CGPA);
   }

   public void displayPostgraduateDetails() {
       System.out.println("Postgraduate Student Name: " + name);
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter roll number: ");
       int rollNumber = sc.nextInt();
       sc.nextLine();
       System.out.print("Enter name: ");
       String name = sc.nextLine();
       System.out.print("Enter CGPA: ");
       double CGPA = sc.nextDouble();
       PostgraduateStudent student = new PostgraduateStudent(rollNumber, name, CGPA);
       student.display();
       student.displayPostgraduateDetails();
   }
}

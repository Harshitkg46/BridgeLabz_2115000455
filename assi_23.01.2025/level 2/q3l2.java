import java.util.Scanner;
public class q3l2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter marks for Physics, Chemistry, and Maths: ");
        int physics = input.nextInt();
        int chemistry = input.nextInt();
        int maths = input.nextInt();

        int total = physics + chemistry + maths;
        double percentage = total / 3.0;

        System.out.println("Average Marks: " + percentage);

        if (percentage >= 90) {
            System.out.println("Grade: A+ (Outstanding)");
        } else if (percentage >= 75) {
            System.out.println("Grade: A (Excellent)");
        } else if (percentage >= 50) {
            System.out.println("Grade: B (Good)");
        } else {
            System.out.println("Grade: F (Fail)");
        }
    }
}


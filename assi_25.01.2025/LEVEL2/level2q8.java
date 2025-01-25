
import java.util.Scanner;
public class level2q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentages = new double[n];
        char[] grades = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1));
            System.out.print("Physics: ");
            physics[i] = validateMarks(sc.nextInt(), sc);
            System.out.print("Chemistry: ");
            chemistry[i] = validateMarks(sc.nextInt(), sc);
            System.out.print("Maths: ");
            maths[i] = validateMarks(sc.nextInt(), sc);

            percentages[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            grades[i] = calculateGrade(percentages[i]);
        }

        System.out.println("Marks, Percentages, and Grades:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": Physics: " + physics[i] + ", Chemistry: " + chemistry[i] +
                    ", Maths: " + maths[i] + ", Percentage: " + percentages[i] + ", Grade: " + grades[i]);
        }
    }

    static int validateMarks(int marks, Scanner sc) {
        while (marks < 0) {
            System.out.print("Marks cannot be negative. Enter again: ");
            marks = sc.nextInt();
        }
        return marks;
    }

    static char calculateGrade(double percentage) {
        if (percentage >= 80) return 'A';
        else if (percentage >= 70) return 'B';
        else if (percentage >= 60) return 'C';
        else if (percentage >= 50) return 'D';
        else if (percentage >= 40) return 'E';
        else return 'R';
    }
}


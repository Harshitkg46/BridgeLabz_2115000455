import java.util.Scanner;
public class level2q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] percentages = new double[n];
        char[] grades = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1));
            System.out.print("Physics: ");
            marks[i][0] = validateMarks(sc.nextInt(), sc);
            System.out.print("Chemistry: ");
            marks[i][1] = validateMarks(sc.nextInt(), sc);
            System.out.print("Maths: ");
            marks[i][2] = validateMarks(sc.nextInt(), sc);

            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            grades[i] = calculateGrade(percentages[i]);
        }

        System.out.println("Marks, Percentages, and Grades:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": Physics: " + marks[i][0] + ", Chemistry: " + marks[i][1] +
                    ", Maths: " + marks[i][2] + ", Percentage: " + percentages[i] + ", Grade: " + grades[i]);
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


import java.util.Random;
import java.util.Scanner;
public class l3q12{
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];
        Random random = new Random();
        for (int i = 0; i < students; i++) {
            scores[i][0] = 50 + random.nextInt(51);
            scores[i][1] = 50 + random.nextInt(51);
            scores[i][2] = 50 + random.nextInt(51);
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static void displayResults(int[][] scores, double[][] results) {
        System.out.println("ID\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.2f\t%.2f\t%.2f%n", i + 1, scores[i][0], scores[i][1], scores[i][2], results[i][0], results[i][1], results[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = scanner.nextInt();
        scanner.close();
        int[][] scores = generateScores(students);
        double[][] results = calculateResults(scores);
        displayResults(scores, results);
    }
}

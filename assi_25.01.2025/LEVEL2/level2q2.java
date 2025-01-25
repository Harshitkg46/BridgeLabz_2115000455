import java.util.Scanner;

public class level2q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        double[] heights = new double[3];
        int youngest = 0;
        double tallest = 0;

        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
            heights[i] = sc.nextDouble();
        }

        youngest = ages[0];
        tallest = heights[0];

        for (int i = 1; i < 3; i++) {
            if (ages[i] < youngest) youngest = ages[i];
            if (heights[i] > tallest) tallest = heights[i];
        }

        System.out.println("Youngest Age: " + youngest);
        System.out.println("Tallest Height: " + tallest);
    }
}

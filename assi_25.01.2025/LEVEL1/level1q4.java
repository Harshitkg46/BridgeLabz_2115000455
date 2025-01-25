

import java.util.Scanner;

public class level1q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        System.out.println("please enter numbers (0 or negative to stop):");
        while (index < 10) {
            double num = sc.nextDouble();
            if (num <= 0) break;
            numbers[index++] = num;
        }
        for (int i = 0; i < index; i++) total += numbers[i];
        System.out.println("The total sum is: " + total);
    }
}

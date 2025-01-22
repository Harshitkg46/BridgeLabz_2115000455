import java.util.Scanner;
public class question9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();
        System.out.println((num1 + num2 + num3) / 3);
        scanner.close();
    }
}

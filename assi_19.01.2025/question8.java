import java.util.Scanner;
public class question8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        double exponent = scanner.nextDouble();
        System.out.println(Math.pow(base, exponent));
        scanner.close();
    } 
}

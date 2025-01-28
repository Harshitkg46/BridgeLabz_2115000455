import java.util.Scanner;

public class l1q7 {
    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int sum = calculateSum(n);
        System.out.printf("The sum of first %d natural numbers is: %d%n", n, sum);
    }
}

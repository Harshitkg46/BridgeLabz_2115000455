import java.util.Scanner;

public class l1q8 {
    public static int[] findSmallestAndLargest(int num1, int num2, int num3) {
        int smallest = Math.min(num1, Math.min(num2, num3));
        int largest = Math.max(num1, Math.max(num2, num3));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int[] result = findSmallestAndLargest(num1, num2, num3);
        System.out.printf("Smallest: %d, Largest: %d%n", result[0], result[1]);
    }
}

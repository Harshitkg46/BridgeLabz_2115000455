import java.util.Scanner;
public class level1q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the countdown start value: ");
        int counter = scanner.nextInt();

        while (counter >= 1) {
            System.out.println("T-minus " + counter);
            counter--;  // Decrement the counter
        }
        System.out.println("Launch!");
    }
}

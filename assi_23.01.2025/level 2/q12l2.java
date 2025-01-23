import java.util.Scanner;
public class q12l2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number > 0) {
            System.out.println("\nMultiples of " + number + " below 100:");
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.println(i);
                    continue; // Skip the remaining part of the loop and move to the next iteration
                }
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }}}


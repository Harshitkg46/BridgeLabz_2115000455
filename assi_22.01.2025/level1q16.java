import java.util.Scanner;

public class level1q16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int students = input.nextInt();

        int handshakes = (students * (students - 1)) / 2;
        System.out.println("The maximum number of handshakes is " + handshakes);
    }
}


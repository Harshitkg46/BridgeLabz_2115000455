import java.util.Scanner;
public class level1q11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();

        System.out.println("The addition is " + (number1 + number2));
        System.out.println("The subtraction is " + (number1 - number2));
        System.out.println("The multiplication is " + (number1 * number2));
        System.out.println("The division is " + (number1 / number2));
    }
}

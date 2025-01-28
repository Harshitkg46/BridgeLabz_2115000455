import java.util.*;
public class l2q9 {
    public static String isPositive(int number) {
        return number >= 0 ? "Positive" : "Negative";
    }

    public static String isEven(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        else if (num1 == num2) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
            System.out.println(isPositive(numbers[i]));
            if (numbers[i] >= 0) {
                System.out.println(isEven(numbers[i]));
            }
        }
        int comparisonResult = compare(numbers[0], numbers[4]);
        if (comparisonResult == 1) {
            System.out.println("First number is greater than last number.");
        } else if (comparisonResult == 0) {
            System.out.println("First number is equal to last number.");
        } else {
            System.out.println("First number is less than last number.");
        }
    }
}


import java.util.Scanner;

public class level1q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Please enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) numbers[i] = sc.nextInt();
        for (int num : numbers) {
            if (num > 0) {
                if (num % 2 == 0) System.out.println(num + " is positive and even.");
                else System.out.println(num + " is positive and odd.");
            } else if (num < 0) System.out.println(num + " is negative.");
            else System.out.println(num + " is zero.");
        }
        if (numbers[0] == numbers[numbers.length - 1]) System.out.println("The first and last elements are equal.");
        else if (numbers[0] > numbers[numbers.length - 1]) System.out.println("The first element is greater than the last.");
        else System.out.println("The first element is less than the last.");
    }
}


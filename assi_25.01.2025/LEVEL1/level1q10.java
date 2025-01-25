
 
import java.util.Scanner;

public class level1q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String[] results = new String[number];
        
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) results[i - 1] = "FizzBuzz";
            else if (i % 3 == 0) results[i - 1] = "Fizz";
            else if (i % 5 == 0) results[i - 1] = "Buzz";
            else results[i - 1] = String.valueOf(i);
        }
        
        for (int i = 0; i < results.length; i++) {
            System.out.println("Position " + (i + 1) + " = " + results[i]);
        }
    }
}

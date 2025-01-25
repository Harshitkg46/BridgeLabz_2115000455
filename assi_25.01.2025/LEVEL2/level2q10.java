 
import java.util.Scanner;
public class level2q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] digits = new int[10];
        int[] freq = new int[10];

        while (num > 0) {
            int digit = num % 10;
            digits[digit]++;
            num /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (digits[i] > 0) {
                System.out.println(i + ": " + digits[i]);
            }
        }
    }
}

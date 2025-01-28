import java.util.Arrays;
public class  l3q3 {
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigitsArray(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2); 
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number) {
        int[] digits = getDigitsArray(number);
        int sum = sumOfDigits(digits);
        return number % sum == 0; 
    }

    public static int[][] digitFrequency(int number) {
        int[] digits = getDigitsArray(number);
        int[] frequency = new int[10]; 

        for (int digit : digits) {
            frequency[digit]++;
        }

       
        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i; 
            result[i][1] = frequency[i]; 
        }
        return result;
    }
    public static void main(String[] args) {
        int number = 1729; 
        System.out.println("Number: " + number);


        System.out.println("Count of digits: " + countDigits(number));


        int[] digits = getDigitsArray(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        System.out.println("Sum of digits: " + sumOfDigits(digits));

        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(digits));

        System.out.println("Is Harshad Number: " + isHarshadNumber(number));

        int[][] frequency = digitFrequency(number);
        System.out.println("Digit frequencies:");
        for (int[] freq : frequency) {
            if (freq[1] > 0) { 
                System.out.println("Digit: " + freq[0] + ", Frequency: " + freq[1]);
            }
        }
    }
}

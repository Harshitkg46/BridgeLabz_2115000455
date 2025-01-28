import java.util.Arrays;
public class l3q4 {

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

    public static int[] reverseDigitsArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversed = reverseDigitsArray(digits);
        return areArraysEqual(digits, reversed);
    }

    public static boolean isDuckNumber(int number) {
        String numStr = String.valueOf(number);
        return numStr.indexOf('0') > 0; 
    }

    public static void main(String[] args) {
        int number = 1221; 
        System.out.println("Number: " + number);

        System.out.println("Count of digits: " + countDigits(number));

  
        int[] digits = getDigitsArray(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        int[] reversedDigits = reverseDigitsArray(digits);
        System.out.println("Reversed digits array: " + Arrays.toString(reversedDigits));

      
        System.out.println("Is Palindrome: " + isPalindrome(number));

        System.out.println("Is Duck Number: " + isDuckNumber(number));
        boolean areEqual = areArraysEqual(digits, reversedDigits);
        System.out.println("Are original and reversed arrays equal: " + areEqual);
    }
}

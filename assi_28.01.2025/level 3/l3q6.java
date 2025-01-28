import java.util.Arrays;
public class l3q6 {
    public static int[] findFactors(int number) {
        int count = 0;

 
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int greatestFactor(int[] factors) {
        int max = Integer.MIN_VALUE;
        for (int factor : factors) {
            if (factor > max) {
                max = factor;
            }
        }
        return max;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static long productOfCubesOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3); 
        }
        return product;
    }

    public static boolean isPerfectNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors) - number; 
        return sum == number;
    }

    public static boolean isAbundantNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors) - number; 
        return sum > number;
    }

    public static boolean isDeficientNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors) - number; 
        return sum < number;
    }
    public static boolean isStrongNumber(int number) {
        int originalNumber = number;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }

        return sum == originalNumber;
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int number = 28;

        System.out.println("Number: " + number);

        int[] factors = findFactors(number);
        System.out.println("Factors: " + Arrays.toString(factors));

        System.out.println("Greatest Factor: " + greatestFactor(factors));

        System.out.println("Sum of Factors: " + sumOfFactors(factors));

        System.out.println("Product of Factors: " + productOfFactors(factors));

        System.out.println("Product of Cubes of Factors: " + productOfCubesOfFactors(factors));

        System.out.println("Is Perfect Number: " + isPerfectNumber(number));

        System.out.println("Is Abundant Number: " + isAbundantNumber(number));

        System.out.println("Is Deficient Number: " + isDeficientNumber(number));

        System.out.println("Is Strong Number: " + isStrongNumber(number));
    }
}

import java.util.Scanner;
public class q7l2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter weight (in kg): ");
        double weight = input.nextDouble();
        System.out.print("Enter height (in cm): ");
        double height = input.nextDouble();

        height = height / 100; // Convert height to meters
        double bmi = weight / (height * height);

        System.out.println("Your BMI is " + bmi);

        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Normal weight");
        } else if (bmi >= 25 && bmi <= 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}



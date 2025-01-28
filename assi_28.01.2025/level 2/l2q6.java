import java.util.*;
public class l2q6{
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double faren = sc.nextDouble();
        double celsi = sc.nextDouble();
        double pounds = sc.nextDouble();
        double kg = sc.nextDouble();
        double gall = sc.nextDouble();
        double ltrs = sc.nextDouble();
        System.out.println(convertFahrenheitToCelsius(faren));
        System.out.println(convertCelsiusToFahrenheit(celsi));
        System.out.println(convertPoundsToKilograms(pounds));
        System.out.println(convertKilogramsToPounds(kg));
        System.out.println(convertGallonsToLiters(gall));
        System.out.println(convertLitersToGallons(ltrs));
    }

}

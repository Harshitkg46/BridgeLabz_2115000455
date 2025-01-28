import java.util.*;
public class l2q5 {
    public static double convertYardsToFeet(double yards) {
        return yards * 3;
    }
    public static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }
    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }
    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }
    public static double convertInchesToCm(double inches) {
        return inches * 2.54;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double km = sc.nextDouble();
        double miles = sc.nextDouble();
        double mtr = sc.nextDouble();
        double inches = sc.nextDouble();
        System.out.println(convertYardsToFeet(km));
        System.out.println(convertFeetToYards(miles));
        System.out.println(convertMetersToInches(mtr));
        System.out.println(convertInchesToMeters(inches));
        System.out.println(convertInchesToCm(inches));

    }
}

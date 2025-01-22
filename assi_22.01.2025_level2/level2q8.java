import java.util.Scanner;

public class level2q8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter the city you are starting from: ");
        String fromCity = input.nextLine();

        System.out.print("Enter the city you will travel via: ");
        String viaCity = input.nextLine();

        System.out.print("Enter the city you are traveling to: ");
        String toCity = input.nextLine();

        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToViaDistance = input.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCityDistance = input.nextDouble();

        System.out.print("Enter the total time taken for the journey in hours: ");
        double timeTaken = input.nextDouble();
        double totalDistance = fromToViaDistance + viaToFinalCityDistance;
        double averageSpeed = totalDistance / timeTaken;
        System.out.println("\nTraveler Name: " + name);
        System.out.println("Route: " + fromCity + " -> " + viaCity + " -> " + toCity);
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Time Taken: " + timeTaken + " hours");
        System.out.println("Average Speed: " + averageSpeed + " miles/hour");
    }
}


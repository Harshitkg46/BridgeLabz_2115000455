import java.util.Scanner;
class Vehicle {
   String ownerName;
   String vehicleType;
   private static double registrationFee = 500.0;
   public Vehicle(String ownerName, String vehicleType) {
       this.ownerName = ownerName;
       this.vehicleType = vehicleType;
   }
   public void display() {
       System.out.println("Owner Name: " + ownerName);
       System.out.println("Vehicle Type: " + vehicleType);
       System.out.println("Registration Fee: " + registrationFee);
   }
   public static void updateFee(double newFee) {
       registrationFee = newFee;
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter new registration fee: ");
       double newFee = sc.nextDouble();
       sc.nextLine();
       Vehicle.updateFee(newFee);

       System.out.print("Enter number of vehicles: ");
       int numVehicles = sc.nextInt();
       sc.nextLine();
       Vehicle[] vehicles = new Vehicle[numVehicles];

       for (int i = 0; i < numVehicles; i++) {
           System.out.print("Enter owner name: ");
           String ownerName = sc.nextLine();
           System.out.print("Enter vehicle type: ");
           String vehicleType = sc.nextLine();
           vehicles[i] = new Vehicle(ownerName, vehicleType);
       }

       System.out.println("\nVehicle Details:");
       for (Vehicle vehicle : vehicles) {
           vehicle.display();
           System.out.println();
       }
   }
}


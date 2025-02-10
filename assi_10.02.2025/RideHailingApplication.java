// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getters and Setters
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        if (vehicleId != null && !vehicleId.trim().isEmpty()) {
            this.vehicleId = vehicleId;
        } else {
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty.");
        }
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        if (driverName != null && !driverName.trim().isEmpty()) {
            this.driverName = driverName;
        } else {
            throw new IllegalArgumentException("Driver name cannot be null or empty.");
        }
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm > 0) {
            this.ratePerKm = ratePerKm;
        } else {
            throw new IllegalArgumentException("Rate per km must be greater than zero.");
        }
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm;
    }
}

// Interface GPS
interface GPS {
    String getCurrentLocation();

    void updateLocation(String newLocation);
}

// Car class
class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Bike class
class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; // 10% discount for bikes
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Auto class
class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.8; // 20% discount for autos
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Main class
public class RideHailingApplication {
    public static void main(String[] args) {
        // Array to store vehicles
        Vehicle[] vehicles = new Vehicle[3];

        // Creating vehicle instances
        vehicles[0] = new Car("C001", "Alice", 15.0);
        vehicles[1] = new Bike("B001", "Bob", 10.0);
        vehicles[2] = new Auto("A001", "Charlie", 8.0);

        // Processing vehicles
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getVehicleDetails());
            double fare = vehicle.calculateFare(10.0); // Calculate fare for 10 km
            System.out.println("Fare for 10 km: " + fare);

            if (vehicle instanceof GPS) {
                GPS gps = (GPS) vehicle;
                gps.updateLocation("Downtown");
                System.out.println("Current Location: " + gps.getCurrentLocation());
            }

            System.out.println("---------------------------");
        }
    }
}

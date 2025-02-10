// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Getters and Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        if (vehicleNumber != null && !vehicleNumber.trim().isEmpty()) {
            this.vehicleNumber = vehicleNumber;
        } else {
            throw new IllegalArgumentException("Vehicle number cannot be null or empty.");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type != null && !type.trim().isEmpty()) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Type cannot be null or empty.");
        }
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        if (rentalRate >= 0) {
            this.rentalRate = rentalRate;
        } else {
            throw new IllegalArgumentException("Rental rate must be non-negative.");
        }
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);
}

// Interface Insurable
interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

// Car class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy Number: " + insurancePolicyNumber;
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2; // 20% extra for trucks
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; // 10% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy Number: " + insurancePolicyNumber;
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Array to store vehicles
        Vehicle[] vehicles = new Vehicle[3];

        // Creating vehicle instances
        vehicles[0] = new Car("CAR123", 500, "INS12345");
        vehicles[1] = new Bike("BIKE456", 200);
        vehicles[2] = new Truck("TRUCK789", 1000, "INS67890");

        // Display rental and insurance details
        for (Vehicle vehicle : vehicles) {
            int days = 5; // Example rental duration
            System.out.println("Vehicle: " + vehicle.getType());
            System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
            System.out.println("Rental Cost for " + days + " days: " + vehicle.calculateRentalCost(days));

            if (vehicle instanceof Insurable) {
                Insurable insurable = (Insurable) vehicle;
                System.out.println("Insurance Cost: " + insurable.calculateInsurance());
                System.out.println("Insurance Details: " + insurable.getInsuranceDetails());
            }

            System.out.println("---------------------------");
        }
    }
}

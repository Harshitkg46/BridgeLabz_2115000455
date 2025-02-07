class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}
interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    private int batteryCapacity; 

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(model + " is charging. Battery capacity: " + batteryCapacity + " kWh.");
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}
class PetrolVehicle extends Vehicle implements Refuelable {
    private double fuelCapacity; // In liters

    public PetrolVehicle(String model, int maxSpeed, double fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel capacity: " + fuelCapacity + " liters.");
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}
class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model S", 250, 100);
        tesla.displayDetails();
        tesla.charge();
        System.out.println("-------------------");
        PetrolVehicle bmw = new PetrolVehicle("BMW M3", 280, 60);
        bmw.displayDetails();
        bmw.refuel();
    }
}

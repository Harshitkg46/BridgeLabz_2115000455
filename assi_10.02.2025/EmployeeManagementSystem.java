import java.util.Scanner;

// Abstract class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        if (employeeId > 0) {
            this.employeeId = employeeId;
        } else {
            throw new IllegalArgumentException("Employee ID must be positive.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            throw new IllegalArgumentException("Base salary must be non-negative.");
        }
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Calculated Salary: " + calculateSalary());
    }
}

// Interface Department
interface Department {
    void assignDepartment(String departmentName);

    String getDepartmentDetails();
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee implements Department {
    private String departmentName;
    private double fixedSalary;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedSalary) {
        super(employeeId, name, baseSalary);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedSalary;
    }

    @Override
    public void assignDepartment(String departmentName) {
        if (departmentName != null && !departmentName.trim().isEmpty()) {
            this.departmentName = departmentName;
        } else {
            throw new IllegalArgumentException("Department name cannot be null or empty.");
        }
    }

    @Override
    public String getDepartmentDetails() {
        return departmentName;
    }
}

// PartTimeEmployee class
class PartTimeEmployee extends Employee implements Department {
    private String departmentName;
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours, double hourlyRate) {
        super(employeeId, name, baseSalary);
        if (workHours < 0 || hourlyRate < 0) {
            throw new IllegalArgumentException("Work hours and hourly rate must be non-negative.");
        }
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (workHours * hourlyRate);
    }

    @Override
    public void assignDepartment(String departmentName) {
        if (departmentName != null && !departmentName.trim().isEmpty()) {
            this.departmentName = departmentName;
        } else {
            throw new IllegalArgumentException("Department name cannot be null or empty.");
        }
    }

    @Override
    public String getDepartmentDetails() {
        return departmentName;
    }
}

// Main class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array to store employees
        Employee[] employees = new Employee[2];

        // Creating FullTimeEmployee and PartTimeEmployee
        FullTimeEmployee fte = new FullTimeEmployee(1, "Alice", 50000, 20000);
        fte.assignDepartment("Engineering");
        employees[0] = fte;

        PartTimeEmployee pte = new PartTimeEmployee(2, "Bob", 20000, 20, 500);
        pte.assignDepartment("Support");
        employees[1] = pte;

        // Displaying employee details using polymorphism
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println("Department: " + ((Department) emp).getDepartmentDetails());
            }
            System.out.println("---------------------------");
        }

        scanner.close();
    }
}

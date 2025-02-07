class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + salary);
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager, Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Developer, Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    private int internshipDuration; 

    public Intern(String name, int id, double salary, int internshipDuration) {
        super(name, id, salary);
        this.internshipDuration = internshipDuration;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Intern, Internship Duration: " + internshipDuration + " months");
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 101, 90000, 10);
        Employee developer = new Developer("Bob", 102, 80000, "Java");
        Employee intern = new Intern("Charlie", 103, 30000, 6);

        manager.displayDetails();
        System.out.println("-------------------");
        developer.displayDetails();
        System.out.println("-------------------");
        intern.displayDetails();
    }
}


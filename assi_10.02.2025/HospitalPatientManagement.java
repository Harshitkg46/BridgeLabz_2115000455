// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (patientId != null && !patientId.trim().isEmpty()) {
            this.patientId = patientId;
        } else {
            throw new IllegalArgumentException("Patient ID cannot be null or empty.");
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be greater than zero.");
        }
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);

    String viewRecords();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int numberOfDays;
    private String medicalHistory = "";

    public InPatient(String patientId, String name, int age, double dailyRate, int numberOfDays) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.numberOfDays = numberOfDays;
    }

    @Override
    public double calculateBill() {
        return dailyRate * numberOfDays;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    @Override
    public String viewRecords() {
        return medicalHistory;
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalHistory = "";

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    @Override
    public String viewRecords() {
        return medicalHistory;
    }
}

// Main class
public class HospitalPatientManagement {
    public static void main(String[] args) {
        // Array to store patients
        Patient[] patients = new Patient[2];

        // Creating patient instances
        patients[0] = new InPatient("P001", "John Doe", 45, 2000, 5);
        patients[1] = new OutPatient("P002", "Jane Smith", 30, 500);

        // Processing patients
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
            System.out.println("Bill Amount: $" + patient.calculateBill());

            if (patient instanceof MedicalRecord) {
                MedicalRecord record = (MedicalRecord) patient;
                record.addRecord("Routine check-up completed.");
                System.out.println("Medical Records: \n" + record.viewRecords());
            }

            System.out.println("---------------------------");
        }
    }
}

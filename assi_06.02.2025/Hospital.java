import java.util.ArrayList;
import java.util.List;

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }
}

class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
        System.out.println("Dr. " + name + " is consulting patient " + patient.getName());
    }

    public void viewPatients() {
        System.out.println("Dr. " + name + " has the following patients:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void viewDoctors() {
        System.out.println("Patient " + name + " has consulted the following doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Dr. " + doctor.name);
        }
    }

    public String getName() {
        return name;
    }
}

class docAndPat {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");
        Doctor doctor1 = new Doctor("Smith");
        Doctor doctor2 = new Doctor("Johnson");
        
        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");
        
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);
        
        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);
        
        doctor1.viewPatients();
        doctor2.viewPatients();
        patient1.viewDoctors();
        patient2.viewDoctors();
    }
}

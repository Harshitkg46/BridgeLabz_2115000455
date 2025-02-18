import java.util.ArrayList;
import java.util.List;

// Abstract class for JobRole
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "Job Role: " + roleName;
    }
}

// Specific job roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private T jobRole;
    private String candidateName;
    private double experienceYears;

    public Resume(T jobRole, String candidateName, double experienceYears) {
        this.jobRole = jobRole;
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public double getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return "Candidate: " + candidateName + ", Experience: " + experienceYears + " years, " + jobRole.toString();
    }
}

// Resume Screening System
class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumePool;

    public ResumeScreeningSystem() {
        resumePool = new ArrayList<>();
    }

    // Add a resume to the system
    public <T extends JobRole> void addResume(Resume<T> resume) {
        resumePool.add(resume);
    }

    // Screen resumes dynamically
    public void screenResumes() {
        System.out.println("Screening Resumes:");
        for (Resume<? extends JobRole> resume : resumePool) {
            System.out.println(resume);
        }
    }

    // Filter resumes based on minimum experience
    public void filterByExperience(double minExperience) {
        System.out.println("Filtering resumes with at least " + minExperience + " years of experience:");
        for (Resume<? extends JobRole> resume : resumePool) {
            if (resume.getExperienceYears() >= minExperience) {
                System.out.println(resume);
            }
        }
    }
}

// Main class
public class AIResumeScreening {
    public static void main(String[] args) {
        // Create resumes for different job roles
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer(), "Alice Johnson", 5.0);
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist(), "Bob Smith", 3.5);
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager(), "Charlie Davis", 7.0);

        // Create Resume Screening System
        ResumeScreeningSystem system = new ResumeScreeningSystem();

        // Add resumes to the system
        system.addResume(seResume);
        system.addResume(dsResume);
        system.addResume(pmResume);

        // Screen all resumes
        System.out.println("All Resumes:");
        system.screenResumes();

        // Filter resumes by experience
        system.filterByExperience(4.0);
    }
}


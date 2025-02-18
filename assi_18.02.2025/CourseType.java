import java.util.ArrayList;
import java.util.List;

// Abstract class for course types
abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course Name: " + courseName;
    }
}

// Specific course types
class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }
}

// Generic Course class
class Course<T extends CourseType> {
    private T courseType;
    private int creditHours;

    public Course(T courseType, int creditHours) {
        this.courseType = courseType;
        this.creditHours = creditHours;
    }

    public T getCourseType() {
        return courseType;
    }

    public int getCreditHours() {
        return creditHours;
    }

    @Override
    public String toString() {
        return courseType.toString() + ", Credit Hours: " + creditHours;
    }
}

// CourseCatalog class
class CourseCatalog {
    private List<Course<? extends CourseType>> courses;

    public CourseCatalog() {
        courses = new ArrayList<>();
    }

    // Add a course to the catalog
    public <T extends CourseType> void addCourse(Course<T> course) {
        courses.add(course);
    }

    // Display all courses in the catalog
    public void displayCourses() {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

// Main class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create course catalog
        CourseCatalog catalog = new CourseCatalog();

        // Create specific courses
        Course<ExamCourse> mathExamCourse = new Course<>(new ExamCourse("Mathematics"), 3);
        Course<AssignmentCourse> javaAssignmentCourse = new Course<>(new AssignmentCourse("Java Programming"), 4);
        Course<ResearchCourse> aiResearchCourse = new Course<>(new ResearchCourse("Artificial Intelligence"), 6);

        // Add courses to the catalog
        catalog.addCourse(mathExamCourse);
        catalog.addCourse(javaAssignmentCourse);
        catalog.addCourse(aiResearchCourse);

        // Display all courses
        System.out.println("University Course Catalog:");
        catalog.displayCourses();
    }}


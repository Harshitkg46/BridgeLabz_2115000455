import java.util.ArrayList;
import java.util.List;

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    public void viewEnrolledCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }
}

class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("Course: " + name + " has enrolled students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class schAndStd {
    public static void main(String[] args) {
        School school = new School("Greenwood High");
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        student1.enrollInCourse(math);
        student1.enrollInCourse(science);
        student2.enrollInCourse(math);

        school.addStudent(student1);
        school.addStudent(student2);

        student1.viewEnrolledCourses();
        student2.viewEnrolledCourses();
        
        math.displayEnrolledStudents();
        science.displayEnrolledStudents();
    }
}

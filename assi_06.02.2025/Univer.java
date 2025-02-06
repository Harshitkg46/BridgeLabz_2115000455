import java.util.ArrayList;
import java.util.List;

class Univer {
    private String name;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public University(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}

class Student {
    private String name;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);
    }

    public void viewEnrolledCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course course : enrolledCourses) {
            System.out.println(course.getName());
        }
    }
}

class Professor {
    private String name;
    private List<Course> assignedCourses;

    public Professor(String name) {
        this.name = name;
        this.assignedCourses = new ArrayList<>();
    }

    public void assignCourse(Course course) {
        assignedCourses.add(course);
        course.assignProfessor(this);
    }

    public void viewAssignedCourses() {
        System.out.println("Professor: " + name + " teaches:");
        for (Course course : assignedCourses) {
            System.out.println(course.getName());
        }
    }
}

class Course {
    private String name;
    private Professor professor;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getName() {
        return name;
    }
}

class uniManag {
    public static void main(String[] args) {
        University university = new University("Tech University");
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        student1.enrollCourse(math);
        student1.enrollCourse(science);
        student2.enrollCourse(math);
        
        professor1.assignCourse(math);
        professor2.assignCourse(science);

        university.addStudent(student1);
        university.addStudent(student2);
        university.addProfessor(professor1);
        university.addProfessor(professor2);
        university.addCourse(math);
        university.addCourse(science);

        student1.viewEnrolledCourses();
        student2.viewEnrolledCourses();
        professor1.viewAssignedCourses();
        professor2.viewAssignedCourses();
    }
}

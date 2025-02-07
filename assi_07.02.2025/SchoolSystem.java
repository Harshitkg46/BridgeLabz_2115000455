
class Person {
    protected String name;
    protected int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public void displayRole() {
        System.out.println("General Person in School");
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Subject: " + subject);
    }
}
class Student extends Person {
    private int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Staff Member");
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}
class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Smith", 40, "Mathematics");
        teacher.displayRole();
        teacher.displayDetails();
        System.out.println("-------------------");
        Student student = new Student("Alice Johnson", 16, 10);
        student.displayRole();
        student.displayDetails();
        System.out.println("-------------------");
        Staff staff = new Staff("Mrs. Brown", 35, "Administration");
        staff.displayRole();
        staff.displayDetails();
    }
}


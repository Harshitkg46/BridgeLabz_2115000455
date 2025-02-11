class StudentNode {
    int rollNo;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private StudentNode head;

    public void addStudent(int rollNo, String name, int age, String grade, String position) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        if (position.equals("beginning")) {
            newNode.next = head;
            head = newNode;
        } else {
            if (head == null) {
                head = newNode;
            } else {
                StudentNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
    }

    public void deleteStudent(int rollNo) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        StudentNode current = head;
        while (current.next != null && current.next.rollNo != rollNo) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Student not found!");
        }
    }

    public StudentNode searchStudent(int rollNo) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNo == rollNo) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateGrade(int rollNo, String newGrade) {
        StudentNode student = searchStudent(rollNo);
        if (student != null) {
            student.grade = newGrade;
        } else {
            System.out.println("Student not found!");
        }
    }

    public void displayStudents() {
        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll No: " + current.rollNo + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        list.addStudent(1, "Alice", 20, "A", "beginning");
        list.addStudent(2, "Bob", 22, "B", "end");
        list.displayStudents();
        list.updateGrade(2, "A");
        list.displayStudents();
        list.deleteStudent(1);
        list.displayStudents();
    }
}

import java.util.Scanner;
class Person {
   String name;
   int age;
   // Constructor
   public Person(String name, int age) {
       this.name = name;
       this.age = age;
   }
   // Copy Constructor
   public Person(Person other) {
       this.name = other.name;
       this.age = other.age;
   }
   public void display() {
       System.out.println("Name: " + name + ", Age: " + age);
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter name: ");
       String name = sc.nextLine();
       System.out.print("Enter age: ");
       int age = sc.nextInt();
      
       // Create original person
       Person p1 = new Person(name, age);       
       // Cloning person using copy constructor
       Person p2 = new Person(p1);
       System.out.println("\nOriginal Person:");
       p1.display();
       System.out.println("\nCloned Person:");
       p2.display();
   }
}


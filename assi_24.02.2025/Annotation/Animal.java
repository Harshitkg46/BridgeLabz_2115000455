class Animal {
   void makeSound() {
       System.out.println("makes sound");
   }
}
class Dog extends Animal{
   @Override
   void makeSound(){
       System.out.println("makes sound bhow bhow");
   }
}
public class OverrideClass {
   public static void main(String[] args) {
       Dog d = new Dog();
       d.makeSound();
   }
}

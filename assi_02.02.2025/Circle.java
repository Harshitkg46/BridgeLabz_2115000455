class Circle {
   double radius;
   // Default constructor
   public Circle() {
       this(1.0); // Calls the parameterized constructor with default value 1.0
   }
   // Parameterized constructor
   public Circle(double radius) {
       this.radius = radius;
   }
   // Getter method for radius
   public double getRadius() {
       return radius;
   }
   // Method to calculate area
   public double getArea() {
       return Math.PI * radius * radius;
   }

   public static void main(String[] args) {
       // Creating circles using different constructors
       Circle obj1= new Circle();
       Circle user= new Circle(6.0);
       System.out.println("Default Circle:");
       System.out.println("Radius: " + obj1.getRadius());
       System.out.println("Area: " + obj1.getArea());
       System.out.println("\nCustom Circle:");
       System.out.println("Radius: " + user.getRadius());
       System.out.println("Area: " + user.getArea());
   }
}


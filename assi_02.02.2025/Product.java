import java.util.Scanner;
class Product {
   String productName;
   double price;
   private static int totalProducts = 0;

   public Product(String productName, double price) {
       this.productName = productName;
       this.price = price;
       totalProducts++;
   }

   public void display() {
       System.out.println("Product Name: " + productName);
       System.out.println("Price: " + price);
   }

   public static void TotalProducts() {
       System.out.println("Total Products Created: " + totalProducts);
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter the number of products: ");
       int numProducts = sc.nextInt();
       sc.nextLine();

       Product[] products = new Product[numProducts];

       for (int i = 0; i < numProducts; i++) {
           System.out.print("Enter product name: ");
           String name = sc.nextLine();
           System.out.print("Enter product price: ");
           double price = sc.nextDouble();
           sc.nextLine();
           products[i] = new Product(name, price);
       }

       System.out.println("\nProduct Details:");
       for (Product product : products) {
           product.display();
           System.out.println();
       }
       Product.TotalProducts();
   }
}


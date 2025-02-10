 // Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        if (productId > 0) {
            this.productId = productId;
        } else {
            throw new IllegalArgumentException("Product ID must be positive.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price must be non-negative.");
        }
    }

    // Abstract method
    public abstract double calculateDiscount();
}

// Interface Taxable
interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    private static final double ELECTRONICS_TAX_RATE = 0.15;

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * ELECTRONICS_TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 15% for Electronics";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    private static final double CLOTHING_TAX_RATE = 0.08;

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.2; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * CLOTHING_TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 8% for Clothing";
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main class
public class ECommercePlatform {
    public static void main(String[] args) {
        // Array to store products
        Product[] products = new Product[3];

        // Creating product instances
        products[0] = new Electronics(1, "Smartphone", 50000);
        products[1] = new Clothing(2, "Jeans", 2000);
        products[2] = new Groceries(3, "Rice", 1000);

        // Display final price for each product
        for (Product product : products) {
            double discount = product.calculateDiscount();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
            double finalPrice = product.getPrice() + tax - discount;

            System.out.println("Product: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);

            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }

            System.out.println("---------------------------");
        }
    }
}

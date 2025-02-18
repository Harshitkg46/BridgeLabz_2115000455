abstract class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Specific product categories
class BookCategory extends Category {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends Category {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends Category {
    public GadgetCategory() {
        super("Gadgets");
    }
}

// Generic Product class
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price + ", Category: " + category.getName();
    }
}

// ProductCatalog class
class ProductCatalog {
    private Product<?>[] products;
    private int count;

    @SuppressWarnings("unchecked")
    public ProductCatalog(int capacity) {
        products = (Product<?>[]) new Product<?>[capacity];
        count = 0;
    }

    // Add a product to the catalog
    public <T extends Category> void addProduct(Product<T> product) {
        if (count < products.length) {
            products[count++] = product;
        } else {
            System.out.println("Catalog is full. Cannot add product: " + product.getName());
        }
    }

    // Display all products in the catalog
    public void displayCatalog() {
        for (int i = 0; i < count; i++) {
            System.out.println(products[i]);
        }
    }

    // Apply discount to a specific product
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(discountedPrice);
        System.out.println("Discount applied to " + product.getName() + ". New price: $" + discountedPrice);
    }
}

// Main class
public class OnlineMarketplace {
    public static void main(String[] args) {
        // Create product catalog with capacity 5
        ProductCatalog catalog = new ProductCatalog(5);

        // Create categories
        BookCategory bookCategory = new BookCategory();
        ClothingCategory clothingCategory = new ClothingCategory();
        GadgetCategory gadgetCategory = new GadgetCategory();

        // Create products
        Product<BookCategory> book1 = new Product<>("The Great Gatsby", 15.99, bookCategory);
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 25.00, clothingCategory);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 699.99, gadgetCategory);

        // Add products to catalog
        catalog.addProduct(book1);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        // Display catalog
        System.out.println("Product Catalog:");
        catalog.displayCatalog();

        // Apply discount to a product
        System.out.println("\nApplying discount:");
        ProductCatalog.applyDiscount(book1, 10);  // Apply 10% discount to the book
        ProductCatalog.applyDiscount(phone, 15); // Apply 15% discount to the smartphone

        // Display catalog after discounts
        System.out.println("\nUpdated Product Catalog:");
        catalog.displayCatalog();
    }
}


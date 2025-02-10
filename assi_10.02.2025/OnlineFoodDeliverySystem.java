// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        if (itemName != null && !itemName.trim().isEmpty()) {
            this.itemName = itemName;
        } else {
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price must be positive.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public String getItemDetails() {
        return "Item Name: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

// Interface Discountable
interface Discountable {
    double applyDiscount();

    String getDiscountDetails();
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1; // 10% discount for veg items
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied.";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 50; // Additional charge for non-veg items
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount for non-veg items
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied.";
    }
}

// Main class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        // Array to store food items
        FoodItem[] items = new FoodItem[2];

        // Creating food item instances
        items[0] = new VegItem("Paneer Butter Masala", 200, 2);
        items[1] = new NonVegItem("Chicken Biryani", 300, 1);

        // Processing food items
        for (FoodItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Total Price: " + item.calculateTotalPrice());

            if (item instanceof Discountable) {
                Discountable discountable = (Discountable) item;
                System.out.println(discountable.getDiscountDetails());
                System.out.println("Discounted Price: " + (item.calculateTotalPrice() - discountable.applyDiscount()));
            }

            System.out.println("---------------------------");
        }
    }
}

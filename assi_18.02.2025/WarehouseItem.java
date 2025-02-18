abstract class WarehouseItem {
    private String name;
    private int quantity;

    public WarehouseItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Item: " + name + ", Quantity: " + quantity;
    }
}

// Specific item classes extending WarehouseItem
class Electronics extends WarehouseItem {
    public Electronics(String name, int quantity) {
        super(name, quantity);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, int quantity) {
        super(name, quantity);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, int quantity) {
        super(name, quantity);
    }
}

// Generic Storage class with bounded type parameter
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    // Add an item to the storage
    public void addItem(T item) {
        items.add(item);
    }

    // Retrieve all items from the storage
    public List<T> getItems() {
        return items;
    }
}

// Utility class to display items
class StorageUtil {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

// Main class to test the implementation
public class SmartWarehouse {
    public static void main(String[] args) {
        // Create specific storage for each type of WarehouseItem
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to respective storages
        electronicsStorage.addItem(new Electronics("Laptop", 10));
        electronicsStorage.addItem(new Electronics("Smartphone", 20));

        groceriesStorage.addItem(new Groceries("Apples", 50));
        groceriesStorage.addItem(new Groceries("Rice", 30));

        furnitureStorage.addItem(new Furniture("Chair", 5));
        furnitureStorage.addItem(new Furniture("Table", 2));

        // Display items from all storages
        System.out.println("Electronics Storage:");
        StorageUtil.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries Storage:");
        StorageUtil.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture Storage:");
        StorageUtil.displayItems(furnitureStorage.getItems());
    }
}

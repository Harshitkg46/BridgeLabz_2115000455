class InventoryNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    InventoryNode next;

    public InventoryNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private InventoryNode head;

    // Add an item at the beginning, end, or a specific position
    public void addItem(String itemName, int itemId, int quantity, double price, String position) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);

        if (position.equals("beginning") || head == null) {
            newNode.next = head;
            head = newNode;
        } else if (position.equals("end")) {
            InventoryNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        } else {
            System.out.println("Invalid position! Use 'beginning' or 'end'.");
        }
    }

    // Remove an item based on Item ID
    public void removeItem(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }

        InventoryNode current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        InventoryNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item based on Item ID or Item Name
    public void searchItem(String searchKey) {
        InventoryNode current = head;
        boolean found = false;

        while (current != null) {
            if (String.valueOf(current.itemId).equals(searchKey) || current.itemName.equalsIgnoreCase(searchKey)) {
                System.out.println("Found -> Item Name: " + current.itemName + ", ID: " + current.itemId + ", Quantity: " + current.quantity + ", Price: " + current.price);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No item found with ID or Name: " + searchKey);
        }
    }

    // Calculate and display the total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        InventoryNode current = head;

        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }

        System.out.println("Total Value of Inventory: $" + totalValue);
    }

    // Display all items in the inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }

        InventoryNode current = head;
        System.out.println("Inventory Items:");
        while (current != null) {
            System.out.println("Item Name: " + current.itemName + ", ID: " + current.itemId + ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }

    // Sort the inventory based on Item Name or Price in ascending or descending order
    public void sortInventory(String sortBy, String order) {
        if (head == null || head.next == null) {
            return;
        }

        boolean ascending = order.equalsIgnoreCase("ascending");
        head = mergeSort(head, sortBy, ascending);
        System.out.println("Inventory sorted by " + sortBy + " in " + order + " order.");
    }

    private InventoryNode mergeSort(InventoryNode node, String sortBy, boolean ascending) {
        if (node == null || node.next == null) {
            return node;
        }

        InventoryNode middle = getMiddle(node);
        InventoryNode nextOfMiddle = middle.next;
        middle.next = null;

        InventoryNode left = mergeSort(node, sortBy, ascending);
        InventoryNode right = mergeSort(nextOfMiddle, sortBy, ascending);

        return sortedMerge(left, right, sortBy, ascending);
    }

    private InventoryNode sortedMerge(InventoryNode left, InventoryNode right, String sortBy, boolean ascending) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        boolean condition;
        if (sortBy.equalsIgnoreCase("price")) {
            condition = ascending ? left.price <= right.price : left.price > right.price;
        } else {
            condition = ascending ? left.itemName.compareTo(right.itemName) <= 0 : left.itemName.compareTo(right.itemName) > 0;
        }

        InventoryNode result;
        if (condition) {
            result = left;
            result.next = sortedMerge(left.next, right, sortBy, ascending);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next, sortBy, ascending);
        }
        return result;
    }

    private InventoryNode getMiddle(InventoryNode node) {
        if (node == null) {
            return node;
        }

        InventoryNode slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

class Main {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        // Add items
        inventory.addItem("Laptop", 1, 5, 800.0, "beginning");
        inventory.addItem("Mouse", 2, 50, 20.0, "end");
        inventory.addItem("Keyboard", 3, 30, 40.0, "end");

        // Display inventory
        inventory.displayInventory();

        // Update quantity
        inventory.updateQuantity(2, 60);

        // Search items
        inventory.searchItem("Mouse");
        inventory.searchItem("Keyboard");

        // Calculate total value
        inventory.calculateTotalValue();

        // Sort inventory by price in ascending order
        inventory.sortInventory("price", "ascending");
        inventory.displayInventory();

        // Remove an item
        inventory.removeItem(1);
        inventory.displayInventory();
    }
}

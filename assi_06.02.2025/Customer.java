import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void viewOrders() {
        System.out.println("Customer: " + name + " has placed the following orders:");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}

class Order {
    private int orderId;
    private List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId + " contains the following products:");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class eCommerce {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");
        Order order1 = new Order(1001);
        Order order2 = new Order(1002);

        Product product1 = new Product("Laptop", 1200.99);
        Product product2 = new Product("Smartphone", 799.49);

        order1.addProduct(product1);
        order1.addProduct(product2);
        order2.addProduct(product2);

        customer.placeOrder(order1);
        customer.placeOrder(order2);

        customer.viewOrders();
    }
}

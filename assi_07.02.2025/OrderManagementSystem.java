class Order {
    protected int orderId;
    protected String orderDate;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}
class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order shipped with Tracking Number: " + trackingNumber;
    }

    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;
    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }

    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

class OrderManagementSystem {
    public static void main(String[] args) {
       
        Order order = new Order(1001, "2025-02-07");
        order.displayOrderDetails();
        System.out.println("-------------------");

        ShippedOrder shippedOrder = new ShippedOrder(1002, "2025-02-06", "TRK123456");
        shippedOrder.displayOrderDetails();
        System.out.println("-------------------");
        DeliveredOrder deliveredOrder = new DeliveredOrder(1003, "2025-02-05", "TRK654321", "2025-02-07");
        deliveredOrder.displayOrderDetails();
    }
}

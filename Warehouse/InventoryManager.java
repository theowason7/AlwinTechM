package Warehouse;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryManager {
    private Map<String, Product> products;
    private PriorityQueue<Order> orderQueue;

    public InventoryManager() {
        products = new ConcurrentHashMap<>();
        orderQueue = new PriorityQueue<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getPriority().compareTo(o2.getPriority());
            }
        });
    }

    // Add product to the inventory
    public synchronized void addProduct(Product product) {
        products.put(product.getProductID(), product);
        System.out.println("Product added: " + product.getName());
    }

    // Process orders
    public void processOrders() {
        // Multithreaded order processing
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            System.out.println("Processing order: " + order.getOrderID());
            processOrder(order);
        }
    }

    private void processOrder(Order order) {
        // Basic logic for processing each order
        for (String productID : order.getProductIDs()) {
            Product product = products.get(productID);
            if (product != null && product.getQuantity() > 0) {
                // Simulate order picking and updating inventory
                System.out.println("Picked product: " + product.getName());
                product.adjustQuantity(-1); // Reduce stock by 1
            } else {
                System.out.println("Out of stock for product: " + productID);
            }
        }
    }

    // Add order to the queue
    public void addOrder(Order order) {
        orderQueue.offer(order);
        System.out.println("Order added: " + order.getOrderID());
    }
}

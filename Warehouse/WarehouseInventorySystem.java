package Warehouse;

import java.util.Arrays;

public class WarehouseInventorySystem {
    public static void main(String[] args) {
        // Create an instance of InventoryManager
        InventoryManager inventoryManager = new InventoryManager();

        // Add products to the inventory
        Location location1 = new Location(1, 2, 3);
        Product product1 = new Product("P001", "Widget", 10, location1);
        inventoryManager.addProduct(product1);

        Location location2 = new Location(2, 3, 4);
        Product product2 = new Product("P002", "Gadget", 5, location2);
        inventoryManager.addProduct(product2);

        // Create orders
        Order order1 = new Order("O001", Arrays.asList("P001", "P002"), Order.Priority.STANDARD);
        Order order2 = new Order("O002", Arrays.asList("P001"), Order.Priority.EXPEDITED);
        inventoryManager.addOrder(order1);
        inventoryManager.addOrder(order2);

        // Process orders in a separate thread
        Runnable orderProcessingTask = () -> {
            inventoryManager.processOrders();
        };

        Thread orderProcessingThread = new Thread(orderProcessingTask);
        orderProcessingThread.start();

        // Wait for the order processing to complete
        try {
            orderProcessingThread.join();
        } catch (InterruptedException e) {
            System.out.println("Order processing interrupted: " + e.getMessage());
        }

        System.out.println("Order processing completed.");
    }
}

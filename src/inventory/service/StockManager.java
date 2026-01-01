package inventory.service;

import inventory.model.Inventory;
import inventory.model.Product;

/**
 * Handles stock-related business operations.
 * Demonstrates separation of business logic.
 */
public class StockManager {

    private Inventory inventory;

    public StockManager(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Increases stock of a product.
     */
    public void increaseStock(String productId, int amount) {
        Product product = inventory.findProductById(productId);
        if (product != null) {
            product.updateStock(amount);
        }
    }

    /**
     * Decreases stock of a product.
     */
    public void decreaseStock(String productId, int amount) {
        Product product = inventory.findProductById(productId);
        if (product != null) {
            product.updateStock(-amount);
        }
    }
}

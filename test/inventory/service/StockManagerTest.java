package inventory.service;

import inventory.model.Inventory;
import inventory.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * StockManager sınıfı için birim testleri içerir.
 */
public class StockManagerTest {

    @Test
    public void testIncreaseStock() {
        Inventory inventory = new Inventory();
        StockManager stockManager = new StockManager(inventory);

        Product product = new Product("P1", "Test Product", 10.0, 5);
        inventory.addProduct(product);

        stockManager.increaseStock("P1", 5);

        assertEquals(10, product.getStockQuantity());
    }
}

package inventory.service;

import inventory.model.Inventory;
import inventory.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * StockManager sınıfı için birim testleri içerir.
 * Stok artırma ve azaltma senaryoları test edilmektedir.
 */
public class StockManagerTest {

    @Test
    public void testIncreaseStock() {
        Inventory inventory = new Inventory();
        Product product = new Product("P1", "Test Product", 10.0, 5);
        inventory.addProduct

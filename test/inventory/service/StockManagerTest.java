package inventory.service;

import inventory.model.Inventory;
import inventory.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * StockManager sınıfı için birim testleri içerir.
 */
public class StockManagerTest {

    @Test
    @DisplayName("Stok artırma işlemi doğru çalışıyor")
    public void testIncreaseStock() {

        System.out.println("TEST BAŞLADI: Stok artırma testi");

        Inventory inventory = new Inventory();
        Product product = new Product("P1", "Test Product", 10.0, 5);

        inventory.addProduct(product);
        inventory.updateStock("P1", 5);

        assertEquals(10, product.getStockQuantity());

        System.out.println("TEST BAŞARILI: Ürün stoğu başarıyla artırıldı");
    }
}

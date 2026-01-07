package inventory.service;

import inventory.model.Inventory;
import inventory.model.Product;

/**
 * StockManager sınıfı, stok ile ilgili iş kurallarını yönetir.
 * Ürünlerin stok artırma ve azaltma işlemleri bu sınıf üzerinden yapılır.
 *
 * Bu sınıf, business logic'in model katmanından ayrılmasını sağlar.
 */
public class StockManager {

    private Inventory inventory;

    /**
     * StockManager nesnesi oluşturur.
     *
     * @param inventory stok işlemlerinin yapılacağı envanter
     */
    public StockManager(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Belirtilen ürüne stok ekler.
     *
     * @param productId stok artırılacak ürünün ID bilgisi
     * @param amount eklenecek stok miktarı
     */
    public void increaseStock(String productId, int amount) {
        Product product = inventory.findProductById(productId);

        if (product == null) {
            System.out.println("❌ Ürün bulunamadı.");
            return;
        }

        if (amount <= 0) {
            System.out.println("❌ Stok artırma miktarı pozitif olmalıdır.");
            return;
        }

        product.updateStock(amount);
    }

    /**
     * Belirtilen üründen stok düşer.
     * Stok miktarının negatif olmasına izin verilmez.
     *
     * @param productId stok azaltılacak ürünün ID bilgisi
     * @param amount azaltılacak stok miktarı
     */
    public void decreaseStock(String productId, int amount) {
        Product product = inventory.findProductById(productId);

        if (product == null) {
            System.out.println("❌ Ürün bulunamadı.");
            return;
        }

        if (amount <= 0) {
            System.out.println("❌ Stok azaltma miktarı pozitif olmalıdır.");
            return;
        }

        if (product.getStockQuantity() < amount) {
            System.out.println("❌ Yetersiz stok! Stok negatif olamaz.");
            return;
        }

        product.updateStock(-amount);
    }
}

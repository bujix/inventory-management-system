package inventory.app;

import inventory.model.Inventory;
import inventory.model.Product;
import inventory.model.PerishableProduct;
import inventory.service.StockManager;

import java.time.LocalDate;

/**
 * Uygulamanın çalıştırılabilir giriş noktası.
 * Demo amaçlı örnek kullanım içerir.
 */
public class Main {

    public static void main(String[] args) {

        // Envanter oluştur
        Inventory inventory = new Inventory();

        // Ürünler oluştur
        Product laptop = new Product("P1", "Laptop", 25000, 10);
        PerishableProduct milk =
                new PerishableProduct("P2", "Süt", 30, 20, LocalDate.now().plusDays(5));

        // Envantere ekle
        inventory.addProduct(laptop);
        inventory.addProduct(milk);

        // StockManager oluştur
        StockManager stockManager = new StockManager(inventory);

        // Stok işlemleri
        stockManager.decreaseStock("P1", 2);
        stockManager.increaseStock("P2", 5);

        // Sonuçları yazdır
        System.out.println("=== ENANTER DURUMU ===");
        System.out.println(laptop.getName() + " stok: " + laptop.getStockQuantity());
        System.out.println(milk.getName() + " stok: " + milk.getStockQuantity());
        System.out.println("Son kullanma tarihi: " + milk.getExpirationDate());
    }
}

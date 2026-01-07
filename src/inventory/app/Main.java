package inventory.app;

import inventory.model.Inventory;
import inventory.model.Product;
import inventory.model.PerishableProduct;
import inventory.service.StockManager;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Menü tabanlı Envanter Yönetim Sistemi
 */
public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        StockManager stockManager = new StockManager(inventory);
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n=== ENVANTER YÖNETİM SİSTEMİ ===");
            System.out.println("1 - Yeni ürün ekle");
            System.out.println("2 - Ürün sil");
            System.out.println("3 - Stok artır");
            System.out.println("4 - Stok azalt");
            System.out.println("5 - Envanteri listele");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer temizle

            switch (choice) {

                case 1 -> {
                    System.out.print("Ürün ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Ürün adı: ");
                    String name = scanner.nextLine();

                    System.out.print("Fiyat: ");
                    double price = scanner.nextDouble();

                    System.out.print("Stok miktarı: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Bozulabilir mi? (E/H): ");
                    String answer = scanner.nextLine();

                    Product product;

                    if (answer.equalsIgnoreCase("E")) {
                        System.out.print("Son kullanma tarihi (YYYY-MM-DD): ");
                        LocalDate date = LocalDate.parse(scanner.nextLine());
                        product = new PerishableProduct(id, name, price, stock, date);
                    } else {
                        product = new Product(id, name, price, stock);
                    }

                    inventory.addProduct(product);
                    System.out.println("✅ Ürün eklendi.");
                }

                case 2 -> {
                    System.out.print("Silinecek ürün ID: ");
                    String id = scanner.nextLine();

                    boolean removed = inventory.removeProductById(id);
                    System.out.println(removed ? "✅ Ürün silindi." : "❌ Ürün bulunamadı.");
                }

                case 3 -> {
                    System.out.print("Ürün ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Artırılacak miktar: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();

                    stockManager.increaseStock(id, amount);
                    System.out.println("✅ Stok artırıldı.");
                }

                case 4 -> {
                    System.out.print("Ürün ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Azaltılacak miktar: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();

                    stockManager.decreaseStock(id, amount);
                    System.out.println("✅ Stok azaltıldı.");
                }

                case 5 -> {
                    System.out.println("\n--- ENVANTER LİSTESİ ---");
                    inventory.getProducts().forEach(p ->
                            System.out.println(
                                    p.getId() + " | " +
                                    p.getName() + " | Stok: " +
                                    p.getStockQuantity()
                            )
                    );
                }

                case 0 -> {
                    inventory.saveToFile();
                    System.out.println("💾 Ürünler products.txt dosyasına kaydedildi.");
                    System.out.println("👋 Programdan çıkılıyor.");
                    running = false;
                }

                default -> System.out.println("❌ Geçersiz seçim.");
            }
        }

        scanner.close();
    }
}


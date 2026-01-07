package inventory.model;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Inventory sınıfı, sistemdeki ürünleri ve siparişleri yönetmekten sorumludur.
 * Ürün ekleme, silme, arama, düşük stok kontrolü ve sipariş takibi işlemlerini sağlar.
 *
 * Bu sınıf composition (bileşim) prensibini gösterir.
 */
public class Inventory {

    private List<Product> products;
    private List<Order> orders;

    /**
     * Boş bir envanter oluşturur.
     */
    public Inventory() {
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    /**
     * Envantere yeni bir ürün ekler.
     *
     * @param product eklenecek ürün
     */
    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    /**
     * Ürün ID'sine göre ürünü envanterden siler.
     *
     * @param id silinecek ürünün ID bilgisi
     * @return ürün silindiyse true, aksi halde false
     */
    public boolean removeProductById(String id) {
        return products.removeIf(p -> p.getId().equals(id));
    }

    /**
     * Ürün ID'sine göre ürünü arar.
     *
     * @param id aranacak ürünün ID bilgisi
     * @return ürün bulunursa Product nesnesi, bulunamazsa null
     */
    public Product findProductById(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Belirtilen eşik değerinin altındaki stoklara sahip ürünleri döndürür.
     *
     * @param threshold minimum stok sınırı
     * @return düşük stoklu ürünlerin listesi
     */
    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStock = new ArrayList<>();
        for (Product p : products) {
            if (p.getStockQuantity() < threshold) {
                lowStock.add(p);
            }
        }
        return lowStock;
    }

    /**
     * Ürün ID'sine göre stok miktarını günceller.
     *
     * @param productId stok güncellenecek ürünün ID'si
     * @param amount stok artış veya azalış miktarı
     */
    public void updateStock(String productId, int amount) {
        Product product = findProductById(productId);
        if (product != null) {
            product.updateStock(amount);
        }
    }

    /**
     * Envantere yeni bir sipariş ekler.
     *
     * @param order eklenecek sipariş
     */
    public void addOrder(Order order) {
        if (order != null) {
            orders.add(order);
        }
    }

    /**
     * Tüm siparişleri döndürür.
     *
     * @return sipariş listesi
     */
    public List<Order> getOrders() {
        return orders;
    }
    /**
 * Envanterdeki tüm ürünleri döndürür.
 *
 * @return ürün listesi
 */
public List<Product> getProducts() {
    return products;
}
/**
 * Ürünleri txt dosyasına kaydeder.
 */
public void saveToFile() {
    try (FileWriter writer = new FileWriter("products.txt")) {
        for (Product p : products) {
            writer.write(
                p.getId() + "," +
                p.getName() + "," +
                p.getPrice() + "," +
                p.getStockQuantity() + "\n"
            );
        }
    } catch (IOException e) {
        System.out.println("Dosyaya yazma hatası!");
    }
}

}

package inventory.model;

import java.time.LocalDate;

/**
 * Bozulabilir ürünleri temsil eden sınıf.
 * Product sınıfından kalıtım alır.
 */
public class PerishableProduct extends Product {

    private LocalDate expirationDate;

    /**
     * Yeni bir bozulabilir ürün oluşturur.
     *
     * @param id ürünün benzersiz kimliği
     * @param name ürün adı
     * @param price ürün fiyatı
     * @param stockQuantity başlangıç stok miktarı
     * @param expirationDate son kullanma tarihi
     */
    public PerishableProduct(
            String id,
            String name,
            double price,
            int stockQuantity,
            LocalDate expirationDate
    ) {
        super(id, name, price, stockQuantity);
        this.expirationDate = expirationDate;
    }

    /**
     * Ürünün son kullanma tarihini döndürür.
     *
     * @return son kullanma tarihi
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}

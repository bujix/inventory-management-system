package inventory.model;

import java.time.LocalDate;

/**
 * Order sınıfı, sistemde oluşturulan bir siparişi temsil eder.
 * Sipariş edilen ürün, miktar ve tarih bilgilerini içerir.
 *
 * Bu sınıf Inventory ile composition ilişkisi içerisindedir.
 */
public class Order {

    private String orderId;
    private Product product;
    private int quantity;
    private LocalDate orderDate;

    /**
     * Yeni bir sipariş oluşturur.
     *
     * @param orderId siparişin benzersiz kimliği
     * @param product sipariş edilen ürün
     * @param quantity sipariş edilen miktar
     */
    public Order(String orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.orderDate = LocalDate.now();
    }

    public String getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}

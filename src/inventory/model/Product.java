package inventory.model;

import inventory.interfaces.Storable;

/**
 * Inventory sistemindeki bir ürünü temsil eder.
 */
public class Product implements Storable {

    private String id;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public void updateStock(int amount) {
        this.stockQuantity += amount;
    }
}

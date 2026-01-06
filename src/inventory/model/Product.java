package inventory.model;

import inventory.interfaces.Storable;

/**
 * Represents a product in the inventory system.
 * Encapsulates basic product information and stock management.
 */
public class Product implements Storable {

    private String id;
    private String name;
    private double price;
    private int stockQuantity;

    /**
     * Creates a new Product.
     *
     * @param id unique product identifier
     * @param name product name
     * @param price product price
     * @param stockQuantity initial stock quantity
     */
    public Product(String id, String name, double price, int stockQuantity) {
        this.id = id;
        this.

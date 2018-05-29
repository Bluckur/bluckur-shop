/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.util.Map;

/**
 * A purchase of a list of products.
 */
public class Purchase {
    /**
     * The id of the purchase.
     */
    private int id;

    /**
     * The total amount of the purchase.
     */
    private int totalAmount;

    /**
     * The customer who did of the purchase.
     */
    private Customer customer;

    /**
     * Whether the purchase has been approved.
     * A purchase can be approved when the required amount of
     * coins is received in validated transactions.
     */
    private boolean approved;

    /**
     * Whether the purchase has been processed. This will currently be done manually.
     * Processed means that the ordered products have all been sent.
     */
    private boolean processed;

    /**
     * A map of the ordered products and the amount of products ordered.
     */
    private Map<Product, Integer> products;

    /**
     * The timestamp in GMT when the purchase was placed.
     */
    private Date timestamp;

    /**
     * Create a purchase
     * @param id {@link #id}
     * @param customer {@link #customer}
     * @param approved {@link #approved}
     * @param processed {@link #processed}
     * @param products {@link #products}
     * @param timestamp {@link #timestamp}
     */
    public Purchase(int id, Customer customer, boolean approved, boolean processed, Map<Product, Integer> products, Date timestamp) {
        if (id < 0) {
            throw new IllegalArgumentException("id cannot be a negative value.");
        }

        if (timestamp.after(new Date())) {
            throw new IllegalArgumentException("timestamp cannot be in the future.");
        }

        this.id = id;
        this.timestamp = timestamp;

        this.setCustomer(customer);
        this.setApproved(approved);
        this.setProcessed(processed);
        this.setProducts(products);
    }

    /**
     * Get the id of the purchase.
     * @return {@link #id}
     */
    public int getId() {
        return id;
    }

    /**
     * Get the total price of the purchase.
     * @return {@link #totalAmount}
     */
    public int getTotalAmount() {
        return this.products.values().stream().mapToInt(Number::intValue).sum();
    }

    /**
     * Get the customer who placed the purchase.
     * @return {@link #customer}
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set the customer who placed the purchase.
     * @param customer {@link #customer}
     */
    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("customer cannot be null.");
        }

        this.customer = customer;
    }

    /**
     * Get whether the purchase has been approved.
     * @return {@link #approved}
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * Set whether the purchase has been approved.
     * @param approved {@link #approved}
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * Get whether the purchase has been processed.
     * @return {@link #processed}
     */
    public boolean isProcessed() {
        return processed;
    }

    /**
     * Set whether the purchase has been processed.
     * @param processed the new value for {@link #processed}
     */
    public void setProcessed(boolean processed) {
        if (processed && !this.approved) {
            throw new IllegalArgumentException("A purchase cannot be processed when not yet approved.");
        }

        this.processed = processed;
    }

    /**
     * Get the map of ordered products and their quantities.
     * @return {@link #products}
     */
    public  Map<Product, Integer> getProducts() {
        return products;
    }

    /**
     * Set the map of ordered products and their quantities.
     * There must be at least one record in the map.
     * There can be no records with a non-positive quantity.
     * @param products the new {@link #products}
     */
    public void setProducts( Map<Product, Integer> products) {
        if (products == null) {
            throw new IllegalArgumentException("products cannot be null.");
        }

        if (products.size() <= 0) {
            throw new IllegalArgumentException("products needs to contain at least one item");
        }

        if (products.values().stream().anyMatch(quantity -> quantity <= 0)) {
            throw new IllegalArgumentException("products cannot contain a record with 0 or less quantity of a product.");
        }

        this.products = products;
    }

    /**
     * Get the timestamp at which the purchase was placed.
     * @return {@link #timestamp}
     */
    public Date getTimestamp() {
        return timestamp;
    }
}

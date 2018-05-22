/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import java.util.List;
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

    public Purchase(int id, Customer customer, boolean approved, boolean processed, Map<Product, Integer> products, Date timestamp) {
        if (id < 0) {
            throw new IllegalArgumentException("id cannot be a negative value.");
        }

        if (timestamp.after(new Date())) {
            throw new IllegalArgumentException("timestamp cannot be in the future.");
        }

        this.id = id;
        this.timestamp = timestamp;

        if (customer == null) {
            throw new IllegalArgumentException("customer cannot be null.");
        }

        if (processed && !approved) {
            throw new IllegalArgumentException("a purchase cannot be processed when not yet approved.");
        }

        if (products == null) {
            throw new IllegalArgumentException("products cannot be null.");
        }

        if (products.size() <= 0) {
            throw new IllegalArgumentException("products needs to contain at least one item");
        }

        if (products.values().stream().anyMatch(quantity -> quantity <= 0)) {
            throw new IllegalArgumentException("products cannot contain a record with 0 or less quantity of a product.");
        }

        this.setTotalAmount(totalAmount);
        this.setCustomer(customer);
        this.setApproved(approved);
        this.setProcessed(processed);
        this.setProducts(products);

        this.totalAmount = totalAmount;
        this.customer = customer;
        this.approved = false; 
        this.processed = false;
        this.products = products;
        this.timestamp = new Date();
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
        return totalAmount;
    }

    private void setTotalAmount(int totalAmount) {
        if (totalAmount < 0) {
            throw new IllegalArgumentException("totalAmount cannot a negative value.");
        }

        this.totalAmount = totalAmount;
    }

    /**
     * Get the customer who placed the purchase.
     * @return {@link #customer}
     */
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Get whether the purchase has been approved.
     * @return {@link #approved}
     */
    public boolean isApproved() {
        return approved;
    }

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

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    /**
     * Get the map of ordered products and their quantities.
     * @return {@link #products}
     */
    public  Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts( Map<Product, Integer> products) {
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

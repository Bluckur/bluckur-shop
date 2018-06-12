/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * A purchase of a list of products.
 */
@Entity
public class Purchase {
    /**
     * The id of the purchase.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The total amount of the purchase.
     */
    private int totalAmount;

    /**
     * The customer who did of the purchase.
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
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
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductLine> products;

    /**
     * The timestamp in GMT when the purchase was placed.
     */
    private Date timestamp;

    public Purchase() { }

    /**
     * Create a purchase
     * @param customer {@link #customer}
     * @param products {@link #products}
     */
    public Purchase(Customer customer, List<ProductLine> products) {
        this.approved = false;
        this.processed = false;
        this.timestamp = new Date();

        this.customer = customer;
        this.products = products;
    }

    /**
     * Get the id of the purchase.
     * @return {@link #id}
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the total price of the purchase.
     * @return {@link #totalAmount}
     */
    public int getTotalAmount() {
        int totalAmount = 0;

        for(ProductLine productLine : products) {
            totalAmount += productLine.getProduct().getPrice() * productLine.getAmount();
        }

        return totalAmount;
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
        this.processed = processed;
    }

    public List<ProductLine> getProducts() {
        return products;
    }

    public void setProducts(List<ProductLine> products) {
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

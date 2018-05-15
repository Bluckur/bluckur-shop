/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ronal
 */
public class Purchase {
    private int id;
    private int totalAmount;
    private Customer customer;
    private boolean approved;
    private boolean processed;
    private List<Product> products;
    private Long timestamp;

    public Purchase(int id, int totalAmount, Customer customer, boolean approved, boolean processed, List<Product> products, Long timestamp) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.approved = approved;
        this.processed = processed;
        this.products = products;
        this.timestamp = timestamp;
    }

    public Purchase(Customer customer, List<Product> products) {
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.approved = false; 
        this.processed = false;
        this.products = products;
        this.timestamp = System.currentTimeMillis() / 1000L;
    }

    public int getId() {
        return id;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}

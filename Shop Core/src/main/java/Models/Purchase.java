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
 *
 * @author Ronal
 */
public class Purchase {
    private int id;
    private int totalAmount;
    private Customer customer;
    private boolean approved;
    private boolean processed;
    private Map<Product, Integer> products;
    private Date timestamp;

    public Purchase(int id, int totalAmount, Customer customer, Map<Product, Integer> products) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.approved = false; 
        this.processed = false;
        this.products = products;
        this.timestamp = new Date();
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

    public  Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts( Map<Product, Integer> products) {
        this.products = products;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    
    
    
    
    
    
    
}

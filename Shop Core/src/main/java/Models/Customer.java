/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.persistence.Entity;

/**
 * A customer of the shop.
 */
@Entity
public class Customer {
    /**
     * A hash of the public key is stored here to be able to identify the user.
     */
    private String publicKeyHash;

    /**
     * The details for contact or delivery. The format for this is free.
     * Can be empty.
     */
    private String details;

    /**
     * Create a new user.
     *
     * @param publicKeyHash {@link #publicKeyHash}
     * @param details {@link #details}
     */
    public Customer(String publicKeyHash, String details) {
        if (publicKeyHash == null || publicKeyHash.isEmpty()) {
            throw new IllegalArgumentException("publicKeyHash can neither be null nor empty");
        }

        if (details == null) {
            throw new IllegalArgumentException("Details cannot be null. It can however be an empty String.");
        }

        this.publicKeyHash = publicKeyHash;
        this.details = details;
    }

    /**
     * Get the hash of the customer's public key.
     * @return {@link #publicKeyHash}
     */
    public String getPublicKeyHash() {
        return this.publicKeyHash;
    }

    /**
     * Get the details of the customer.
     * @return {@link #details}
     */
    public String getDetails() {
        return this.details;
    }
}

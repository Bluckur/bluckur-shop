/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Ronal
 */
public class Customer {
    private Long id;
    private String publicKeyHash;
    private String details;

    public Customer() {}

    public Customer(Long id, String publicKeyHash, String details) {
        this(publicKeyHash, details);
        this.id = id;
    }

    public Customer(String publicKeyHash, String details) {
        this.publicKeyHash = publicKeyHash;
        this.details = details;
    }

    public String getPublicKeyHash() {
        return publicKeyHash;
    }

    public String getDetails() {
        return details;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

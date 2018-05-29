/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A type of product which can be ordered in the shop.
 */
@Entity
public class Product {
    /**
     * The id of the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The price of the product in coins.
     */
    private int price;

    /**
     * The path to the products' image.
     */
    private String imagePath;

    /**
     * The name of the product.
     */
    private String name;

    /**
     * A description of the product.
     */
    private String description;

    /**
     * The quantity of this product still in stock.
     */
    private int quantity;

    protected Product() {}

    /**
     * Create a new Product.
     * @param price {@link #price}
     * @param imagePath {@link #imagePath}
     * @param name {@link #name}
     * @param description {@link #description}
     * @param quantity {@link #quantity}
     */
    public Product(int price, String imagePath, String name, String description, int quantity) {
        this.setPrice(price);
        this.setImagePath(imagePath);
        this.setName(name);
        this.setDescription(description);
        this.setQuantity(quantity);
    }

    /**
     * Get the id of the product.
     * @return {@link #id}
     */
    public int getId() {
        return id;
    }

    /**
     * Get the price of the product.
     * @return {@link #price}
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the price of the product.
     * @param price the new {@link #price}. Cannot be a negative value.
     */
    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("price cannot be native value.");
        }

        this.price = price;
    }

    /**
     * Get the path to the product's image.
     * @return {@link #imagePath}
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Set the path to the product's image.
     * @param imagePath the new {@link #imagePath}
     */
    public void setImagePath(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            throw new IllegalArgumentException(("imagePath can neither be null nor empty"));
        }

        this.imagePath = imagePath;
    }

    /**
     * Get the name of the product.
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product.
     * @param name the new {@link #name}
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(("name can neither be null nor empty"));
        }

        this.name = name;
    }

    /**
     * Get the description of the product.
     * @return {@link #description}
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the product.
     * @param description the new {@link #description}
     */
    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException(("description cannot be null."));
        }

        this.description = description;
    }

    /**
     * Get the quantity in stock of this product.
     * @return {@link #quantity}
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity in stock of this product.
     * @param quantity the new {@link #quantity}. Cannot be negative value.
     */
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity cannot be negative value.");
        }

        this.quantity = quantity;
    }
}

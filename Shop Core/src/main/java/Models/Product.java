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
public class Product {
    private int id;
    private int price;
    private String imagePath;
    private String name;
    private String description;
    private int quantity;
    private boolean available;

    public Product() {}

    public Product(int id, int price, String imagePath, String name, String description, int quantity, boolean available) {
        this(price, imagePath, name, description, quantity, available);
        this.id = id;
    }

    public Product(int price, String imagePath, String name, String description, int quantity, boolean available) {
        this.price = price;
        this.imagePath = imagePath;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

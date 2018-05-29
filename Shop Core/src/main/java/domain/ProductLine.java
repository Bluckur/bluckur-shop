package domain;

import javax.persistence.*;

/**
 * Created by sguldemond on 29/05/2018.
 */
@Entity
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Product product;
    private Integer amount;

    public ProductLine() {
    }

    public ProductLine(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

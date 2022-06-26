package com.example.examenyoussefchanane.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Optional;

@Entity(name = "product")
public class Product {
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName =  "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )

    @Id
    private Long id;
    private String productName;
    private Integer productPrice;
    @ManyToOne
    @JoinColumn(name = "category")
    @JsonBackReference
    private Category category;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public Category getCategory() {
        return category;
    }
}

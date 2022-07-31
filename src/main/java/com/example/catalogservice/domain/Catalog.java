package com.example.catalogservice.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Catalog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=120, nullable = false, unique = true)
    private String productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer unitPrice;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void calculateStock(int quantity) {
        this.stock -= quantity;
    };
}

package com.example.catalogservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CatalogDto implements Serializable {
    private String productId;
    private int unitPrice;
    private int quantity;
    private int totalPrice;

    private String userId;
    private String orderId;
}

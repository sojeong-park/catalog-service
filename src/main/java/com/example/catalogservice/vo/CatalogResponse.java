package com.example.catalogservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogResponse {
    private String productId;
    private String productName;
    private int unitPrice;
    private int stock;
    private Date createAt;
}

package com.curat.eshopbackend.product;

import lombok.Data;

@Data
public class AddProductRequest {

    private String name;
    private Integer categoryId;
    private Integer price;
    private Integer quantity;
    private String description;
    private String image;
}

package com.curat.eshopbackend.product.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class AddProductDTO {

    @NotNull
    private String name;
    @NotNull
    private Integer categoryId;
    @NotNull
    private Integer price;
    @Positive
    private Integer quantity;
    private String description;
    private String image;
}

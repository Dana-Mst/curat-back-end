package com.curat.eshopbackend.product.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddProductDTO {

    @NotNull
    private String name;
    @NotNull
    private Integer categoryId;

    private Integer price;

    private Integer quantity;
    private String description;

}

package com.curat.eshopbackend.product;

import com.curat.eshopbackend.category.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "shop_seq_product")
    @SequenceGenerator(name = "shop_seq_product", sequenceName = "SHOP_SEQ_PRODUCT", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToOne
    @JsonIgnore
    private Category category;

    private Integer price;
    private Integer quantity;
    private String description;

    private String image;

}

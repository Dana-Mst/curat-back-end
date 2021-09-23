package com.curat.eshopbackend.product;

import com.curat.eshopbackend.category.Category;
import lombok.*;

import javax.persistence.*;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;

    @ManyToOne
    private Category category;

    private Integer price;
    private Integer quantity;
    private String description;

    private String image;

}

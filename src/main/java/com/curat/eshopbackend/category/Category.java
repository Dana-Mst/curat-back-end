package com.curat.eshopbackend.category;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Column(length = 1000)
    private String description;

    private String image;

}

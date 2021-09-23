package com.curat.eshopbackend.recipe;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

    @ElementCollection
    private List<String> ingredients;

    @Column(length = 2000)
    private String preparation;
    private String image;
    private LocalDate dateAdded;

}

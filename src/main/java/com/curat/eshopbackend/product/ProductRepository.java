package com.curat.eshopbackend.product;

import com.curat.eshopbackend.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    Tipul parametrului Lista
//    findAllBy <ce ne trebuie noua> Category
//    Param <tip si nume (irelevant) - descriptiv
//

    List<Product> findAllByCategory(Category category);
    List<Product> findByNameContaining(String searchName);

}


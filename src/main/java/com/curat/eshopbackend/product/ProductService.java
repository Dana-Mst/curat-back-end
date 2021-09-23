package com.curat.eshopbackend.product;

import com.curat.eshopbackend.category.Category;
import com.curat.eshopbackend.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;


    public void addProduct(AddProductRequest request) throws Exception {
        Category category = categoryService.findById(request.getCategoryId());

        Product product = Product
                .builder()
                .id(UUID.randomUUID())
                .category(category)
                .description(request.getDescription())
                .image(request.getImage())
                .name(request.getName())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();

        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(UUID id) throws Exception {
//TODO: Update not found exception
        return productRepository.findById(id).orElseThrow(() ->
                new Exception(String.format("Product with id: %s not found", id))
        );
    }
}

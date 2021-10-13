package com.curat.eshopbackend.product;

import com.curat.eshopbackend.category.Category;
import com.curat.eshopbackend.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Product getProduct(Long id) throws Exception {
//TODO: Update not found exception
        return productRepository.findById(id).orElseThrow(() ->
                new Exception(String.format("Product with id: %s not found", id))
        );
    }

    public List<Product> findByNameContaining(String searchName) {
        return productRepository.findByNameContaining(searchName);
    }

    public List<Product> findAllByCategory(String categoryName) {
        List<Product> productsByCategory = new ArrayList<>();
        try{
            Category category = categoryService.findByName(categoryName);
            productsByCategory =  productRepository.findAllByCategory(category);
        } catch(Exception exception) {
//            TODO handle exception
        }
        return productsByCategory;
    }

    public Boolean deleteProduct(Long id) {
        try{
            productRepository.deleteById(id);
        } catch(Exception exception) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

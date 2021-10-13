package com.curat.eshopbackend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody AddProductRequest product) throws Exception {
        productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) throws Exception {
        return productService.getProduct(id);
    }

    @GetMapping("/category/{categoryName}")
    public List<Product> findAllByCategory(@PathVariable String categoryName) {
        return productService.findAllByCategory(categoryName);
    }

    @GetMapping("/search")
    public List<Product> findByNameContaining(@RequestParam String searchName) {
        return productService.findByNameContaining(searchName);
    }

    //TODO delete product -validations

    @DeleteMapping("/delete/{id}")
    public Boolean deleteProduct(@PathVariable Long id ) {
        return productService.deleteProduct(id);
    }

    //TODO update product

}

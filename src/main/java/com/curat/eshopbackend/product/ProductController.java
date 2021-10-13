package com.curat.eshopbackend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public Product getProduct(@PathVariable UUID id) throws Exception {
        return productService.getProduct(id);
    }

    //TODO delete product -validations

    @DeleteMapping("/delete/{id}")
    public Boolean deleteProduct(@PathVariable UUID id ) {
        return productService.deleteProduct(id);
    }

    //TODO update product

}

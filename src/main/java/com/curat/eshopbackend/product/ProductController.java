package com.curat.eshopbackend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
    public void addProduct(@RequestPart String product, @RequestPart MultipartFile image ) throws Exception {

        productService.addProduct(product, image);
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
    public Boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    //TODO update product

}

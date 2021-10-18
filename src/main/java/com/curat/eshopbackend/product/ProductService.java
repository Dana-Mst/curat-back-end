package com.curat.eshopbackend.product;

import com.curat.eshopbackend.category.Category;
import com.curat.eshopbackend.category.CategoryService;
import com.curat.eshopbackend.image.FileStorageService;
import com.curat.eshopbackend.image.exceptions.FileStorageException;
import com.curat.eshopbackend.product.dto.AddProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private FileStorageService fileStorageService;




    public void addProduct(String product, MultipartFile image) throws Exception {
        AddProductDTO addProductDTO = new AddProductDTO();
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            addProductDTO = objectMapper.readValue(product, AddProductDTO.class);
        } catch( IOException exception) {
//            TODO implement Exception
        }

        StringBuilder str = new StringBuilder();
        String productName = addProductDTO.getName();
        String imageName = fileStorageService.storeFile(image, productName);

              
        
        Category category = categoryService.findById(addProductDTO.getCategoryId());

        Product productToSave = Product
                .builder()
                .category(category)
                .description(addProductDTO.getDescription())
                .image(imageName)
                .name(productName)
                .price(addProductDTO.getPrice())
                .quantity(addProductDTO.getQuantity())
                .build();

        productRepository.save(productToSave);

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

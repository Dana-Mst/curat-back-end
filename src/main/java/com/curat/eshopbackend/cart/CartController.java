package com.curat.eshopbackend.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PutMapping( "/{userId}")
    public Cart addProduct(@PathVariable Long userId, @RequestBody ItemModel itemModel) throws Exception {
        return cartService.addProduct(userId, itemModel);
    }
}

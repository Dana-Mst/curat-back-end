package com.curat.eshopbackend.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addProduct(Long userId, ItemModel item) throws Exception {

        Cart cart = findByUserId(userId);

        boolean itemIsInCart =  cart.getItemList().stream().anyMatch(itemInCart -> itemInCart.getProductId().equals(item.getProductId()));

        if (itemIsInCart) {
            ItemModel existingItem = cart.getItemList().stream().filter(item1 -> item1.getProductId().equals(item.getProductId())).collect(Collectors.toList()).get(0);
            existingItem.setQuantity(existingItem.getQuantity() + 1);
            cart.getItemList().add(existingItem);
        } else cart.getItemList().add(item);

        return cart;
    }
    public Cart findById(Long id) throws Exception {
        return cartRepository
                .findById(id)
                .orElseThrow(() -> new Exception(String.format("Cart with id %d not found", id)));
    }

    public Cart findByUserId(Long id) throws Exception {
        return cartRepository
                .findByUserModelId(id)
                .orElseThrow(() -> new Exception(String.format("User with id %d not found", id)));
    }


}

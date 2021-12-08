package com.curat.eshopbackend.user;

import com.curat.eshopbackend.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(CreateUserDto createUserDto) {
        UserModel userModelToSave = UserModel.builder()
                .email(createUserDto.getEmail())
                .password(createUserDto.getPassword())
                .cart(new Cart())
                .build();

        userRepository.save(userModelToSave);


    }
}

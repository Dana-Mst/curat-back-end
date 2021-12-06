package com.curat.eshopbackend.user;

import com.curat.eshopbackend.cart.Cart;
import com.curat.eshopbackend.order.Address;
import com.curat.eshopbackend.order.Order;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String password;

    private Role role;

    @OneToOne(mappedBy = "userModel")
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    @OneToMany(mappedBy = "user")
    private Set<Address> addresses;


}

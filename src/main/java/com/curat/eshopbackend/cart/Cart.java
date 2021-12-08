package com.curat.eshopbackend.cart;

import com.curat.eshopbackend.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name="item_model_id")
    private Set<ItemModel> itemList = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "cart", referencedColumnName = "id")
    private UserModel userModel;

}

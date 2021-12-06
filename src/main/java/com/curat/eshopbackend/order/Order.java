package com.curat.eshopbackend.order;

import com.curat.eshopbackend.user.UserModel;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate orderTime;

    @ManyToOne
    @JoinColumn(name = "userModel_id")
    private UserModel user;




}

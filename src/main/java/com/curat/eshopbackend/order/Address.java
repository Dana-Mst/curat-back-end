/*package com.curat.eshopbackend.order;

import com.curat.eshopbackend.user.UserModel;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String country;
    private String streetName;
    private String streetNumber;
    private String zipCode;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;



}*/

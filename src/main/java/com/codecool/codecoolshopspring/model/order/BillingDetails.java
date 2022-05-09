package com.codecool.codecoolshopspring.model.order;


import lombok.Data;

@Data
public class BillingDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String address2;
    private String country;
    private String state;
    private String zipCode;
}

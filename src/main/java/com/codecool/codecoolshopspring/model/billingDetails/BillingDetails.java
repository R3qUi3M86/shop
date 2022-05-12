package com.codecool.codecoolshopspring.model.billingDetails;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
public class BillingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String address;
    private String address2;
    @NotEmpty
    private String country;
    @NotEmpty
    private String state;
    @NotEmpty
    @Size(min = 6, max = 6)
    private String zipCode;

    public void removeRejectedValue(Object rejectedValue) {
        System.out.println(rejectedValue);
        if (firstName == rejectedValue) {
            firstName = null;
        } else if (lastName == rejectedValue) {
            lastName = null;
        } else if (email == rejectedValue) {
            email = null;
        } else if (address == rejectedValue) {
            address = null;
        } else if (country == rejectedValue) {
            country = null;
        } else if (state == rejectedValue) {
            state = null;
        } else if (zipCode == rejectedValue) {
            zipCode = null;
        }
    }
}

package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.billingDetails.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingDetailsRepository extends JpaRepository<BillingDetails, Integer> {
}

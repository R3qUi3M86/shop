package com.codecool.codecoolshopspring.service.billingDetails;

import com.codecool.codecoolshopspring.model.billingDetails.BillingDetails;
import com.codecool.codecoolshopspring.repository.BillingDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillingDetailsService {
    private final BillingDetailsRepository billingDetailsRepository;

    public void putBillingDetails(BillingDetails billingDetails){
        billingDetailsRepository.save(billingDetails);
    }
}

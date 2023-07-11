package com.zippy.api.service;

import com.zippy.api.document.BillingInformation;
import com.zippy.api.document.Credential;
import com.zippy.api.dto.UpdateBillingInformationDTO;
import com.zippy.api.exception.BillingInformationNotFoundException;
import com.zippy.api.repository.BillingInformationRepository;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Service
public class BillingInformationService {
    private final BillingInformationRepository billingInformationRepository;

    public BillingInformationService(BillingInformationRepository billingInformationRepository) {
        this.billingInformationRepository = billingInformationRepository;
    }

    public BillingInformation saveBillingInformation(BillingInformation billingInformation){
        return billingInformationRepository.save(billingInformation);
    }

    public void deleteBillingInformationById(ObjectId id) {
        billingInformationRepository.deleteById(id);
    }

    public BillingInformation getBillingInformation(ObjectId id)throws BillingInformationNotFoundException {
        return billingInformationRepository.findById(id)
                        .orElseThrow(()->new BillingInformationNotFoundException("información de pago no encontrada"));
    }

    public BillingInformation disccountMoney(ObjectId id, BigDecimal amount){
        BillingInformation billingInformation = getBillingInformation(id);
        billingInformation.getWallet().setBalance(billingInformation.getWallet().getBalance().subtract(amount));
        return saveBillingInformation(billingInformation);
    }

}

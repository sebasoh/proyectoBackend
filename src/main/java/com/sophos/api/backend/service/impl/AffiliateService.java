package com.sophos.api.backend.service.impl;

import com.sophos.api.backend.models.AffiliateModel;
import com.sophos.api.backend.repository.AffiliateRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffiliateService {

    @Autowired
    private AffiliateRepository affiliateRepository;

    public ArrayList<AffiliateModel> getList() {
        return (ArrayList<AffiliateModel>) affiliateRepository.findAll();

    }

    public Optional<AffiliateModel> getById(Long id) {
        return affiliateRepository.findById(id);

    }

    public AffiliateModel post(AffiliateModel affiliate) {
        return affiliateRepository.save(affiliate);

    }

    public boolean deleteById(Long id) {
        try {
            affiliateRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }

    }
}

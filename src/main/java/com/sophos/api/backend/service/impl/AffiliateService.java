package com.sophos.api.backend.service.impl;

import com.sophos.api.backend.models.AffiliateModel;
import com.sophos.api.backend.repository.AffiliateRepository;
import com.sophos.api.backend.service.IAffiliateService;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffiliateService implements IAffiliateService {

	@Autowired
	private AffiliateRepository affiliateRepository;

	@Override
	public ArrayList<AffiliateModel> getList() {
		return (ArrayList<AffiliateModel>) affiliateRepository.findAll();
	}

	@Override
	public AffiliateModel getById(Long id) {
		Optional<AffiliateModel> affiliate = affiliateRepository.findById(id);
		if (affiliate.isPresent()) {
			return affiliate.get();
		} else {
			return null;
		}
	}

	@Override
	public AffiliateModel post(AffiliateModel affiliate) {
		return affiliateRepository.save(affiliate);
	}

	@Override
	public AffiliateModel put(AffiliateModel affiliate, Long id) {
		try {
			Optional<AffiliateModel> affiliateFound = affiliateRepository.findById(id);
			if (affiliateFound.isPresent()) {
				return affiliateRepository.save(affiliate);
			}
		} catch (Exception e) {
			return null;

		}
		return affiliateRepository.save(affiliate);

	}

	@Override
	public boolean deleteById(Long id) {
		try {
			affiliateRepository.deleteById(id);
			return true;
		} catch (Exception error) {
			return false;
		}
	}

}

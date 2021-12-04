package com.sophos.api.backend.service;

import java.util.ArrayList;

import com.sophos.api.backend.models.AffiliateModel;

public interface IAffiliateService {

	ArrayList<AffiliateModel> getList();

	AffiliateModel getById(Long id);

	AffiliateModel post(AffiliateModel test);

	AffiliateModel put(AffiliateModel test, Long id);

	boolean deleteById(Long id);

}

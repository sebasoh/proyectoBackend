package com.sophos.api.backend.service;

import java.util.ArrayList;
import java.util.Optional;

import com.sophos.api.backend.models.AffiliateModel;

public interface IAffiliateService {
		
		ArrayList<AffiliateModel> getList(); 
	
	    Optional<AffiliateModel> getById(Long id);

	    AffiliateModel post(AffiliateModel test);
	    
	    AffiliateModel put(AffiliateModel test);

	    boolean deleteById(Long id);

}

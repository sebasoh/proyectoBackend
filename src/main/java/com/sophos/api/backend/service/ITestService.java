package com.sophos.api.backend.service;

import java.util.ArrayList;
import java.util.Optional;

import com.sophos.api.backend.models.TestModel;

public interface ITestService {
	
	    ArrayList<TestModel> getList();

	    Optional<TestModel> getById(Long id);

	    TestModel post(TestModel test);
	    
	    TestModel put(TestModel test);

	    boolean deleteById(Long id);

}

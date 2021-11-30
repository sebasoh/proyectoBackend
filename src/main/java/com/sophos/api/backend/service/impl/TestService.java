package com.sophos.api.backend.service.impl;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.api.backend.models.TestModel;
import com.sophos.api.backend.repository.TestRepository;
import com.sophos.api.backend.service.ITestService;

@Service
public class TestService implements ITestService{

    @Autowired
    private TestRepository testRepository;

	@Override
	public ArrayList<TestModel> getList() {
		return (ArrayList<TestModel>) testRepository.findAll();
	}
	

	@Override
	public Optional<TestModel> getById(Long id) {
		return testRepository.findById(id);

	}

	@Override
	public TestModel post(TestModel test) {
		return testRepository.save(test);
	}

	@Override
	public TestModel put(TestModel test) {
		return testRepository.save(test);
	}

	@Override
	public boolean deleteById(Long id) {
		try {
            testRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
		
	}

	


 


}

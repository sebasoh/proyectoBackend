package com.sophos.api.backend.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sophos.api.backend.models.TestModel;
import com.sophos.api.backend.repository.TestRepository;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public ArrayList<TestModel> getList() {
        return (ArrayList<TestModel>) testRepository.findAll();

    }

    public Optional<TestModel> getById(Long id) {
        return testRepository.findById(id);

    }

    public TestModel post(TestModel test) {
        return testRepository.save(test);

    }

    public boolean deleteById(Long id) {
        try {
            testRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }

    }

}

package com.sophos.api.backend.service;

import java.util.ArrayList;

import com.sophos.api.backend.models.TestModel;

public interface ITestService {

	ArrayList<TestModel> getList();

	TestModel getById(Long id);

	TestModel post(TestModel test);

	TestModel put(TestModel test, Long id);

	boolean deleteById(Long id);

}

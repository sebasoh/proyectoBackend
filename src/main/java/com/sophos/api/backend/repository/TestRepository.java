package com.sophos.api.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sophos.api.backend.models.TestModel;

@Repository
public interface TestRepository extends CrudRepository<TestModel, Long> {

}

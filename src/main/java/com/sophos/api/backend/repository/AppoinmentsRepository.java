
package com.sophos.api.backend.repository;

import com.sophos.api.backend.models.AppoinmentsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppoinmentsRepository extends CrudRepository<AppoinmentsModel, Long>{
    
}

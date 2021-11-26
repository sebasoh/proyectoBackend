
package com.sophos.api.backend.repository;

import com.sophos.api.backend.models.AppointmentsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentsRepository extends CrudRepository<AppointmentsModel, Long>{
    
}


package com.sophos.api.backend.repository;

import com.sophos.api.backend.models.AffiliateModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliateRepository extends CrudRepository<AffiliateModel, Long> {

} 

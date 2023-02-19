package com.walmart.zeus.dao;

import com.walmart.zeus.domain.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TenantRepository extends MongoRepository<Tenant, String> {
}

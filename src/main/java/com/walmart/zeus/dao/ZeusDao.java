package com.walmart.zeus.dao;

import com.walmart.zeus.domain.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ZeusDao {

    @Autowired
    TenantRepository tenantRepository;

    public void saveTenant(Tenant tenant){
        tenantRepository.save(tenant);
    }


}

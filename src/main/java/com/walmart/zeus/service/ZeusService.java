package com.walmart.zeus.service;

import com.walmart.zeus.dao.ZeusDao;
import com.walmart.zeus.domain.Tenant;
import com.walmart.zeus.dto.TaskDTO;
import com.walmart.zeus.dto.TaskDetailsDTO;
import com.walmart.zeus.dto.TenantDTO;
import com.walmart.zeus.mapper.TenantMapper;
import com.walmart.zeus.resource.ZeusResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ZeusService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZeusResource.class);

    @Autowired
    ZeusDao zeusDao;

    @Autowired
    TenantMapper tenantMapper;

    public void registerTenant(TenantDTO tenantDTO){
        LOGGER.info("[registerTenant] initiating tenant registration");
        Tenant tenant = tenantMapper.tenantDTOToTenant(tenantDTO);
        tenant.set_id(UUID.randomUUID().toString());
        zeusDao.saveTenant(tenant);
    }

    public List<TaskDTO> fetchApprovaltaskList(String app){
        return Arrays.asList(new TaskDTO(app));
    }

    public TaskDetailsDTO fetchtaskDetails(String taskID){
        TaskDetailsDTO taskDetailsDTO = new TaskDetailsDTO();
        Map<String, Object> details = new HashMap<>();
        details.put(taskID, new String("Awesome"));
        taskDetailsDTO.setDetails(details);
        return taskDetailsDTO;
    }

    public void trigerButtonEvents(String event){

    }
}

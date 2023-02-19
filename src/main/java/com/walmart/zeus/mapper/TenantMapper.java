package com.walmart.zeus.mapper;
import com.walmart.zeus.domain.Tenant;
import com.walmart.zeus.dto.TenantDTO;
import org.mapstruct.Mapper;

@Mapper
public abstract class TenantMapper {
     public abstract Tenant tenantDTOToTenant(TenantDTO tenantDTO);
     public abstract TenantDTO tenantToTenantDTO(Tenant tenant);

}

package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Organization;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrganizationRepository extends CrudRepository<Organization, UUID> {
}

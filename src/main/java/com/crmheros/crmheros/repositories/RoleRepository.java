package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
}

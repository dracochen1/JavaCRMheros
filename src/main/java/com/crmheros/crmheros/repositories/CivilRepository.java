package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Civil;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CivilRepository extends CrudRepository<Civil, UUID> {

}

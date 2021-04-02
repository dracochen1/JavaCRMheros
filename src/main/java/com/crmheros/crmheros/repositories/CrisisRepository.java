package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Crisis;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CrisisRepository extends CrudRepository<Crisis, UUID>{
}

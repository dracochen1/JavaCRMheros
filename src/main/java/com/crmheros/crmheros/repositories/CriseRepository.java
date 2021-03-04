package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Civil;
import com.crmheros.crmheros.models.Crise;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CriseRepository extends CrudRepository<Crise, UUID>{
}

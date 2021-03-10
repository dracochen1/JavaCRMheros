package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Incident;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IncidentRepository extends CrudRepository<Incident, UUID> {
}

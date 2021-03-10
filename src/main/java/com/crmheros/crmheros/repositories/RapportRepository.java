package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Rapport;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RapportRepository extends CrudRepository<Rapport, UUID> {
}

package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Satisfaction;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SatisfactionRepository extends CrudRepository<Satisfaction, UUID> {
}

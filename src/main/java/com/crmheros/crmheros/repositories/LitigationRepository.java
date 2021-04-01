package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Litigation;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LitigationRepository extends CrudRepository<Litigation, UUID> {
}

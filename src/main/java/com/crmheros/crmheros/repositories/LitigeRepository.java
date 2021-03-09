package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Litige;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LitigeRepository extends CrudRepository<Litige, UUID> {
}

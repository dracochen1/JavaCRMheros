package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Super;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SuperRepository extends CrudRepository<Super, UUID> {
}

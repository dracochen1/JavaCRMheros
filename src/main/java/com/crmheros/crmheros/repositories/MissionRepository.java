package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Mission;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MissionRepository extends CrudRepository<Mission, UUID> {
}

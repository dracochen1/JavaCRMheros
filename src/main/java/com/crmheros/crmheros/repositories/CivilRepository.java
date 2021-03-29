package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Civil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;


public interface CivilRepository extends CrudRepository<Civil, UUID> {
    Optional<Civil> findByMail(@Param("mail") String mail);
}

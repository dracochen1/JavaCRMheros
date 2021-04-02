package com.crmheros.crmheros.repositories;

import com.crmheros.crmheros.models.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ReportRepository extends CrudRepository<Report, UUID> {
}

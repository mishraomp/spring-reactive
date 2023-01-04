package com.om.example.repository;

import com.om.example.entity.EmployeeEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface EmployeeRepository extends ReactiveCrudRepository<EmployeeEntity, UUID> {
}

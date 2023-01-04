package com.om.example.service;

import com.om.example.entity.EmployeeEntity;
import com.om.example.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class EmployeeService {
  private final EmployeeRepository repository;

  public Flux<EmployeeEntity> getAllEmployees(){
    return repository.findAll();
  }
}

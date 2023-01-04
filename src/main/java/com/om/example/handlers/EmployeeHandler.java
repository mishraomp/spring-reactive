package com.om.example.handlers;

import com.om.example.service.EmployeeService;
import com.om.example.struct.Employee;
import com.om.example.utils.util.HandlerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeHandler {
  private final EmployeeService employeeService;

  public Mono<ServerResponse> getAllEmployees(ServerRequest request) {
    return
      employeeService
        .getAllEmployees()
        .map(el -> Employee.createEmployee(el))
        .collectList().flatMap( response -> ServerResponse.ok()
          .body(response, List.class))
        .doOnError(ResponseStatusException.class, HandlerUtils.handleStatusResponse())
        .doOnError(HandlerUtils.handleError());
  }
}

package com.om.example.struct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.om.example.entity.EmployeeEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Employee(@JsonProperty("employee_id")
                       UUID employeeId,

                       @JsonProperty("first_name")
                       String firstName,

                       @JsonProperty("last_name")
                       String lastName,

                       @JsonProperty("email")
                       String email,

                       @JsonProperty("phone_number")
                       String phone,

                       @JsonProperty("hire_date")
                       LocalDate hireDate,

                       @JsonProperty("salary")
                       Double salary) {
  public static Employee createEmployee(EmployeeEntity employeeEntity) {
    return new Employee(employeeEntity.getEmployeeId(), employeeEntity.getFirstName(), employeeEntity.getLastName(), employeeEntity.getEmail(), employeeEntity.getPhone(), employeeEntity.getHireDate(), employeeEntity.getSalary());
  }
}

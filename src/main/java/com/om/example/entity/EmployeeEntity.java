package com.om.example.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table(name="EMPLOYEE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@With
public class EmployeeEntity {

  @Id
  @Column("EMPLOYEE_ID")
  UUID employeeId;

  @Column("FIRST_NAME")
  String firstName;

  @Column("LAST_NAME")
  String lastName;

  @Column("EMAIL")
  String email;

  @Column("PHONE_NUMBER")
  String phone;

  @Column("HIRE_DATE")
  LocalDate hireDate;

  @Column("SALARY")
  Double salary;

}

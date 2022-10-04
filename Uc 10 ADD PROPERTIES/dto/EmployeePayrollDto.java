package com.example.employeepayroll.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class EmployeePayrollDto {
  
    public String firstName;
 
    private String lastName;
   
    private String address;

    private String companyName;

    private Long salary;

    private String department;

    private Date startDate;  
}

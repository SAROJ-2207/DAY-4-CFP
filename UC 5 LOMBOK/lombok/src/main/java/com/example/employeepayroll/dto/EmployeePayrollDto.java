package com.example.employeepayroll.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmployeePayrollDto {
    public String firstName;
    private String lastName;
    private String companyName;
}

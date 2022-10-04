package com.example.employeepayroll.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class EmployeePayrollDto {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee FirstName Is Invalid!!!")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee LastName Is Invalid!!!")
    private String lastName;

 
    @NotEmpty(message = " Address may not be null")
    private String address;

    @NotEmpty(message = "Company name May not be empty")
    private String companyName;

}

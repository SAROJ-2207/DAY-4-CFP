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

    @Pattern(regexp = "male|female",message = "Gender need to be a provided")
    private String gender;

     @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "ProfilePic cannot be empty")
    private String profilePic;

    @NotEmpty(message = " Address may not be null")
    private String address;

    @NotEmpty(message = "Company name May not be empty")
    private String companyName;

    @Min(value = 5000,message = "Salary cannot be less than 5000")
    @Max(value = 15000,message = "Salary cannot be less than 5000")
    private Long salary;

    @NotNull(message = "Department Should not be empty")
    private String department;

    @NotNull(message = " StartDate Should not be null")
    @PastOrPresent(message = "StartDate should be past or todays date")
    private Date startDate;  //yyyy-mm-dd
}

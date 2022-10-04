package com.example.employeepayroll.model;

import com.example.employeepayroll.dto.EmployeePayrollDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

/*– This is essentially a Data Model that will eventually saved in the DB.*/
public class EmployeePayrollDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;
    private String firstName;
    private String lastName;
    private String companyName;
    private long salary;
    private String department;

    public EmployeePayrollDataModel(long employeeId, EmployeePayrollDto employeePayrollDto) {
    }
//    private String registrationData;
//    private String updatedData;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



    public EmployeePayrollDataModel(EmployeePayrollDto employeePayrollDto) {
            this.firstName =employeePayrollDto.getFirstName();
            this.lastName = employeePayrollDto.getLastName();
            this.companyName = employeePayrollDto.getCompanyName();
            this.salary = employeePayrollDto.getSalary();
            this.department = employeePayrollDto.getDepartment();
//            this.registrationData = employeePayrollDto.getRegistrationDate();
//            this.updatedData = employeePayrollDto.getUpdatedDate();
    }
    public EmployeePayrollDataModel() {

    }

}
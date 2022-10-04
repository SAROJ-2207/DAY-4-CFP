package com.example.employeepayroll.model;

import com.example.employeepayroll.dto.EmployeePayrollDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity

/*– This is essentially a Data Model that will eventually saved in the DB.*/
public class EmployeePayrollDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private String note;
    private String profilePic;
    private String address;
    private String companyName;
    private long salary;
    private String department;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public EmployeePayrollDataModel(long employeeId, EmployeePayrollDto employeePayrollDto) {
    }

    public EmployeePayrollDataModel(EmployeePayrollDto employeePayrollDto) {
            this.firstName =employeePayrollDto.getFirstName();
            this.lastName = employeePayrollDto.getLastName();
            this.gender = employeePayrollDto.getGender();
            this.note=employeePayrollDto.getNote();
            this.profilePic = employeePayrollDto.getProfilePic();
            this.address = employeePayrollDto.getAddress();
            this.companyName = employeePayrollDto.getCompanyName();
            this.salary = employeePayrollDto.getSalary();
            this.department = employeePayrollDto.getDepartment();
            this.startDate = employeePayrollDto.getStartDate();

    }
    public EmployeePayrollDataModel() {

    }

}